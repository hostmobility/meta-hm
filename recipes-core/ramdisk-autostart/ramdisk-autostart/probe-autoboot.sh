#!/bin/sh

while [ -z `ls /media/ | grep sd 2>/dev/null` ]; do	
	sleep 1;
done

AUTOBOOT_PATH=`find /media/ -name autoboot.sh`;

if [ -n "$AUTOBOOT_PATH" ]; then
	logger "Autoboot.sh path found: ${AUTOBOOT_PATH}"
	logger "Will run autoboot sequence"
	sh ${AUTOBOOT_PATH}
else
	logger "Could not find autoboot.sh file. Exiting"
	exit 1
fi


ERROR_CODE=$?

if [ "$ERROR_CODE" -gt "0" ]; then
	logger "Recieved return value other then 0 from $AUTOBOOT_PATH. Error code: $ERROR_CODE"
	exit ${ERROR_CODE}
fi

echo "Success"
exit 0
