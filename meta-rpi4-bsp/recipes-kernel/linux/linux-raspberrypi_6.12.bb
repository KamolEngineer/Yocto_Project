DESCRIPTION = "Linux.Kernel for Raspberry Pi"
SECTION = "kernel"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

COMPATIBLE_MACHINE ?= "rpi4"

require recipes-kernel/linux/linux-yocto.inc

LINUX_VERSION ?= "6.12.34"

PV = "${LINUX_VERSION}+git${SRCPV}"

SRC_URI = "git://github.com/raspberrypi/linux.git;protocol=https;branch=rpi-6.12.y;name=main \
    git://git.yoctoproject.org/yocto-kernel-cache;type=kmeta;name=meta;branch=${LINUX_RPI_KMETA_BRANCH};destsuffix=${KMETA} "

KMETA = "kernel-meta"
LINUX_RPI_KMETA_BRANCH ?= "yocto-6.12"

SRCREV_main = "8f77e03530f65209a377d25023e912b288e039cd"
SRCREV_meta = "96ce9b7ee67702aec75816c4d44a527061c418c5"

KCONFIG_MODE = "--alldefconfig"
KBUILD_DEFCONFIG:rpi4 = "bcm2711_defconfig"

KERNEL_DTC_FLAGS += "-@ -H epapr"