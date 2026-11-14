DESCRIPTION = "Closed source binary files for booting Raspberry Pi devices."
LICENSE = "Broadcom-RPi"
LIC_FILES_CHKSUM = "file://LICENCE.broadcom;md5=c403841ff2837657b2ed8e5bb474ac8d"

COMPATIBLE_MACHINE = "rpi4"

PV = "1.20250430"

SRC_URI = "https://github.com/raspberrypi/firmware/archive/refs/tags/${PV}.tar.gz;downloadfilename=raspberrypi-firmware-${PV}.tar.gz \
           file://cmdline.txt \
           file://config.txt \
           "

SRC_URI[sha256sum] = "69e41ec5ecae7054dfeb307380d03ce4d7ac3e6049b9dfb285ab1ebef8cf04d6"

S = "${WORKDIR}/firmware-${PV}/boot"

inherit deploy

nopackages = "1"

BOOTFILES_DIR_NAME = "bootfiles"

do_deploy() {
    install -d ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}

    install -m 0644 ${S}/*.dat ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}
    install -m 0644 ${S}/*.elf ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}
    install -m 0644 ${S}/bcm2711-rpi-4-b.dtb ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}

    install -m 0644 ${WORKDIR}/cmdline.txt ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/
    install -m 0644 ${WORKDIR}/config.txt ${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/
}

addtask deploy after do_compile