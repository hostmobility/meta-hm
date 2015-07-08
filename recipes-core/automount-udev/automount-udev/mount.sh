#!/bin/sh
#
# Called from udev
#
# Attempt to mount any added block devices and umount any removed devices
MOUNT="/bin/mount"
PMOUNT="/usr/bin/pmount"
UMOUNT="/bin/umount"
ULTRA_MMC_CMD="/sbin/configmmc.sh"
for line in `grep -v ^# /etc/udev/mount.blacklist`
do
        if [ ` expr match "$DEVNAME" "$line" ` -gt 0 ];
        then
                logger "udev/mount.sh" "[$DEVNAME] is blacklisted, ignoring"
                exit 0
        fi
done

automount() {
        name="`basename "$DEVNAME"`"

        if [[ "$name"] == *mmc* ]]; then
                if [ -x "$ULTRA_MMC_CMD" ]; then
                        $ULTRA_MMC_CMD -d $DEVNAME                        
                fi
        fi        

        ! test -d "/media/$name" && mkdir -p "/media/$name"        

        if ! $MOUNT -t auto $DEVNAME "/media/$name"
        then
                logger "mount.sh/automount" "$MOUNT -t auto $DEVNAME \"/media/$name\" failed!"
                rm_dir "/media/$name"
        else
                logger "mount.sh/automount" "Auto-mount of [/media/$name] successful"
                touch "/tmp/.automount-$name"
                
                if [[ "$name"] == *mmc* ]]; then
                        if [ -x "$ULTRA_MMC_CMD" ]; then
                                logger "mount.sh/automount" "Change owner to ultra."                        
                                /bin/chown -R ultra:users /media/$name
                        fi
                fi        
        fi        
}

rm_dir() {
        # We do not want to rm -r populated directories
        if test "`find "$1" | wc -l | tr -d " "`" -lt 2 -a -d "$1"
        then
                ! test -z "$1" && rm -r "$1"
        else
                logger "mount.sh/automount" "Not removing non-empty directory [$1]"
        fi
}

# This is needed since we call this script vi systemd when mounting to 
# prevent udev timeout
if [ "$1" == "add" ]; then
        ACTION="add"
fi

if [ "$ACTION" = "add" ] && [ -n "$DEVNAME" ]; then
        if [ -x "$PMOUNT" ]; then
                $PMOUNT $DEVNAME 2> /dev/null
        elif [ -x $MOUNT ]; then
                $MOUNT $DEVNAME 2> /dev/null
        fi

        # If the device isn't mounted at this point, it isn't configured in fstab
        grep -q "^$DEVNAME " /proc/mounts || automount
fi



if [ "$ACTION" = "remove" ] && [ -x "$UMOUNT" ] && [ -n "$DEVNAME" ]; then
        for mnt in `cat /proc/mounts | grep "$DEVNAME" | cut -f 2 -d " " `
        do
                $UMOUNT $mnt
        done

        # Remove empty directories from auto-mounter
        name="`basename "$DEVNAME"`"
        test -e "/media/$name" && rm_dir "/media/$name"
fi

