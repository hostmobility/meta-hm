require swt-gtk.inc

PR = "r0"

SRC_URI = "http://archive.eclipse.org/eclipse/downloads/drops4/R-4.2.2-201302041200/swt-4.2.2-gtk-linux-x86.zip;name=swt \
           file://Makefile"

SRC_URI[swt.md5sum] = "5616638049866fedf33cd4ad01168e54"
SRC_URI[swt.sha256sum] = "6008af06bb70c90f895524fa75f0ac191368e3b0465a326d0a0c0c790dd4b338"

# A number which is used by SWT to mark the shared libraries.
SWT_API_VERSION = "3.8"

PROVIDES = "swt-gtk"

RCONFLICTS_${PN} = "libswt3.4-gtk-java libswt3.5-gtk-java"

LIC_FILES_CHKSUM = "file://about_files/pixman-licenses.txt;md5=decf26762197e47e6311d35f3cdea1e8"
