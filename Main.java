package com.company;

//package homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Main {

    static int[] s =
            {
                    0x63, 0x7C, 0x77, 0x7B, 0xF2, 0x6B, 0x6F, 0xC5, 0x30, 0x01, 0x67, 0x2B, 0xFE, 0xD7, 0xAB, 0x76,
                    0xCA, 0x82, 0xC9, 0x7D, 0xFA, 0x59, 0x47, 0xF0, 0xAD, 0xD4, 0xA2, 0xAF, 0x9C, 0xA4, 0x72, 0xC0,
                    0xB7, 0xFD, 0x93, 0x26, 0x36, 0x3F, 0xF7, 0xCC, 0x34, 0xA5, 0xE5, 0xF1, 0x71, 0xD8, 0x31, 0x15,
                    0x04, 0xC7, 0x23, 0xC3, 0x18, 0x96, 0x05, 0x9A, 0x07, 0x12, 0x80, 0xE2, 0xEB, 0x27, 0xB2, 0x75,
                    0x09, 0x83, 0x2C, 0x1A, 0x1B, 0x6E, 0x5A, 0xA0, 0x52, 0x3B, 0xD6, 0xB3, 0x29, 0xE3, 0x2F, 0x84,
                    0x53, 0xD1, 0x00, 0xED, 0x20, 0xFC, 0xB1, 0x5B, 0x6A, 0xCB, 0xBE, 0x39, 0x4A, 0x4C, 0x58, 0xCF,
                    0xD0, 0xEF, 0xAA, 0xFB, 0x43, 0x4D, 0x33, 0x85, 0x45, 0xF9, 0x02, 0x7F, 0x50, 0x3C, 0x9F, 0xA8,
                    0x51, 0xA3, 0x40, 0x8F, 0x92, 0x9D, 0x38, 0xF5, 0xBC, 0xB6, 0xDA, 0x21, 0x10, 0xFF, 0xF3, 0xD2,
                    0xCD, 0x0C, 0x13, 0xEC, 0x5F, 0x97, 0x44, 0x17, 0xC4, 0xA7, 0x7E, 0x3D, 0x64, 0x5D, 0x19, 0x73,
                    0x60, 0x81, 0x4F, 0xDC, 0x22, 0x2A, 0x90, 0x88, 0x46, 0xEE, 0xB8, 0x14, 0xDE, 0x5E, 0x0B, 0xDB,
                    0xE0, 0x32, 0x3A, 0x0A, 0x49, 0x06, 0x24, 0x5C, 0xC2, 0xD3, 0xAC, 0x62, 0x91, 0x95, 0xE4, 0x79,
                    0xE7, 0xC8, 0x37, 0x6D, 0x8D, 0xD5, 0x4E, 0xA9, 0x6C, 0x56, 0xF4, 0xEA, 0x65, 0x7A, 0xAE, 0x08,
                    0xBA, 0x78, 0x25, 0x2E, 0x1C, 0xA6, 0xB4, 0xC6, 0xE8, 0xDD, 0x74, 0x1F, 0x4B, 0xBD, 0x8B, 0x8A,
                    0x70, 0x3E, 0xB5, 0x66, 0x48, 0x03, 0xF6, 0x0E, 0x61, 0x35, 0x57, 0xB9, 0x86, 0xC1, 0x1D, 0x9E,
                    0xE1, 0xF8, 0x98, 0x11, 0x69, 0xD9, 0x8E, 0x94, 0x9B, 0x1E, 0x87, 0xE9, 0xCE, 0x55, 0x28, 0xDF,
                    0x8C, 0xA1, 0x89, 0x0D, 0xBF, 0xE6, 0x42, 0x68, 0x41, 0x99, 0x2D, 0x0F, 0xB0, 0x54, 0xBB, 0x16
            };

    static int[] invs =
            {


                    0x52, 0x09, 0x6A, 0xD5, 0x30, 0x36, 0xA5, 0x38, 0xBF, 0x40, 0xA3, 0x9E, 0x81, 0xF3, 0xD7, 0xFB  ,
                    0x7C, 0xE3, 0x39, 0x82, 0x9B, 0x2F, 0xFF, 0x87, 0x34, 0x8E, 0x43, 0x44, 0xC4, 0xDE, 0xE9, 0xCB ,
                    0x54, 0x7B, 0x94, 0x32, 0xA6, 0xC2, 0x23, 0x3D, 0xEE, 0x4C, 0x95, 0x0B, 0x42, 0xFA, 0xC3, 0x4E  ,
                    0x08, 0x2E, 0xA1, 0x66, 0x28, 0xD9, 0x24, 0xB2, 0x76, 0x5B, 0xA2, 0x49, 0x6D, 0x8B, 0xD1, 0x25  ,
                    0x72, 0xF8, 0xF6, 0x64, 0x86, 0x68, 0x98, 0x16, 0xD4, 0xA4, 0x5C, 0xCC, 0x5D, 0x65, 0xB6, 0x92  ,
                    0x6C, 0x70, 0x48, 0x50, 0xFD, 0xED, 0xB9, 0xDA, 0x5E, 0x15, 0x46, 0x57, 0xA7, 0x8D, 0x9D, 0x84  ,
                    0x90, 0xD8, 0xAB, 0x00, 0x8C, 0xBC, 0xD3, 0x0A, 0xF7, 0xE4, 0x58, 0x05, 0xB8, 0xB3, 0x45, 0x06  ,
                    0xD0, 0x2C, 0x1E, 0x8F, 0xCA, 0x3F, 0x0F, 0x02, 0xC1, 0xAF, 0xBD, 0x03, 0x01, 0x13, 0x8A, 0x6B  ,
                    0x3A, 0x91, 0x11, 0x41, 0x4F, 0x67, 0xDC, 0xEA, 0x97, 0xF2, 0xCF, 0xCE, 0xF0, 0xB4, 0xE6, 0x73  ,
                    0x96, 0xAC, 0x74, 0x22, 0xE7, 0xAD, 0x35, 0x85, 0xE2, 0xF9, 0x37, 0xE8, 0x1C, 0x75, 0xDF, 0x6E  ,
                    0x47, 0xF1, 0x1A, 0x71, 0x1D, 0x29, 0xC5, 0x89, 0x6F, 0xB7, 0x62, 0x0E, 0xAA, 0x18, 0xBE, 0x1B  ,
                    0xFC, 0x56, 0x3E, 0x4B, 0xC6, 0xD2, 0x79, 0x20, 0x9A, 0xDB, 0xC0, 0xFE, 0x78, 0xCD, 0x5A, 0xF4  ,
                    0x1F, 0xDD, 0xA8, 0x33, 0x88, 0x07, 0xC7, 0x31, 0xB1, 0x12, 0x10, 0x59, 0x27, 0x80, 0xEC, 0x5F  ,
                    0x60, 0x51, 0x7F, 0xA9, 0x19, 0xB5, 0x4A, 0x0D, 0x2D, 0xE5, 0x7A, 0x9F, 0x93, 0xC9, 0x9C, 0xEF  ,
                    0xA0, 0xE0, 0x3B, 0x4D, 0xAE, 0x2A, 0xF5, 0xB0, 0xC8, 0xEB, 0xBB, 0x3C, 0x83, 0x53, 0x99, 0x61  ,
                    0x17, 0x2B, 0x04, 0x7E, 0xBA, 0x77, 0xD6, 0x26, 0xE1, 0x69, 0x14, 0x63, 0x55, 0x21, 0x0C, 0x7D
            };


    static int[] table2={
            0x00,0x02,0x04,0x06,0x08,0x0a,0x0c,0x0e,0x10,0x12,0x14,0x16,0x18,0x1a,0x1c,0x1e,
            0x20,0x22,0x24,0x26,0x28,0x2a,0x2c,0x2e,0x30,0x32,0x34,0x36,0x38,0x3a,0x3c,0x3e,
            0x40,0x42,0x44,0x46,0x48,0x4a,0x4c,0x4e,0x50,0x52,0x54,0x56,0x58,0x5a,0x5c,0x5e,
            0x60,0x62,0x64,0x66,0x68,0x6a,0x6c,0x6e,0x70,0x72,0x74,0x76,0x78,0x7a,0x7c,0x7e,
            0x80,0x82,0x84,0x86,0x88,0x8a,0x8c,0x8e,0x90,0x92,0x94,0x96,0x98,0x9a,0x9c,0x9e,
            0xa0,0xa2,0xa4,0xa6,0xa8,0xaa,0xac,0xae,0xb0,0xb2,0xb4,0xb6,0xb8,0xba,0xbc,0xbe,
            0xc0,0xc2,0xc4,0xc6,0xc8,0xca,0xcc,0xce,0xd0,0xd2,0xd4,0xd6,0xd8,0xda,0xdc,0xde,
            0xe0,0xe2,0xe4,0xe6,0xe8,0xea,0xec,0xee,0xf0,0xf2,0xf4,0xf6,0xf8,0xfa,0xfc,0xfe,
            0x1b,0x19,0x1f,0x1d,0x13,0x11,0x17,0x15,0x0b,0x09,0x0f,0x0d,0x03,0x01,0x07,0x05,
            0x3b,0x39,0x3f,0x3d,0x33,0x31,0x37,0x35,0x2b,0x29,0x2f,0x2d,0x23,0x21,0x27,0x25,
            0x5b,0x59,0x5f,0x5d,0x53,0x51,0x57,0x55,0x4b,0x49,0x4f,0x4d,0x43,0x41,0x47,0x45,
            0x7b,0x79,0x7f,0x7d,0x73,0x71,0x77,0x75,0x6b,0x69,0x6f,0x6d,0x63,0x61,0x67,0x65,
            0x9b,0x99,0x9f,0x9d,0x93,0x91,0x97,0x95,0x8b,0x89,0x8f,0x8d,0x83,0x81,0x87,0x85,
            0xbb,0xb9,0xbf,0xbd,0xb3,0xb1,0xb7,0xb5,0xab,0xa9,0xaf,0xad,0xa3,0xa1,0xa7,0xa5,
            0xdb,0xd9,0xdf,0xdd,0xd3,0xd1,0xd7,0xd5,0xcb,0xc9,0xcf,0xcd,0xc3,0xc1,0xc7,0xc5,
            0xfb,0xf9,0xff,0xfd,0xf3,0xf1,0xf7,0xf5,0xeb,0xe9,0xef,0xed,0xe3,0xe1,0xe7,0xe5
    };

    static int[] table3={
            0x00,0x03,0x06,0x05,0x0c,0x0f,0x0a,0x09,0x18,0x1b,0x1e,0x1d,0x14,0x17,0x12,0x11,
            0x30,0x33,0x36,0x35,0x3c,0x3f,0x3a,0x39,0x28,0x2b,0x2e,0x2d,0x24,0x27,0x22,0x21,
            0x60,0x63,0x66,0x65,0x6c,0x6f,0x6a,0x69,0x78,0x7b,0x7e,0x7d,0x74,0x77,0x72,0x71,
            0x50,0x53,0x56,0x55,0x5c,0x5f,0x5a,0x59,0x48,0x4b,0x4e,0x4d,0x44,0x47,0x42,0x41,
            0xc0,0xc3,0xc6,0xc5,0xcc,0xcf,0xca,0xc9,0xd8,0xdb,0xde,0xdd,0xd4,0xd7,0xd2,0xd1,
            0xf0,0xf3,0xf6,0xf5,0xfc,0xff,0xfa,0xf9,0xe8,0xeb,0xee,0xed,0xe4,0xe7,0xe2,0xe1,
            0xa0,0xa3,0xa6,0xa5,0xac,0xaf,0xaa,0xa9,0xb8,0xbb,0xbe,0xbd,0xb4,0xb7,0xb2,0xb1,
            0x90,0x93,0x96,0x95,0x9c,0x9f,0x9a,0x99,0x88,0x8b,0x8e,0x8d,0x84,0x87,0x82,0x81,
            0x9b,0x98,0x9d,0x9e,0x97,0x94,0x91,0x92,0x83,0x80,0x85,0x86,0x8f,0x8c,0x89,0x8a,
            0xab,0xa8,0xad,0xae,0xa7,0xa4,0xa1,0xa2,0xb3,0xb0,0xb5,0xb6,0xbf,0xbc,0xb9,0xba,
            0xfb,0xf8,0xfd,0xfe,0xf7,0xf4,0xf1,0xf2,0xe3,0xe0,0xe5,0xe6,0xef,0xec,0xe9,0xea,
            0xcb,0xc8,0xcd,0xce,0xc7,0xc4,0xc1,0xc2,0xd3,0xd0,0xd5,0xd6,0xdf,0xdc,0xd9,0xda,
            0x5b,0x58,0x5d,0x5e,0x57,0x54,0x51,0x52,0x43,0x40,0x45,0x46,0x4f,0x4c,0x49,0x4a,
            0x6b,0x68,0x6d,0x6e,0x67,0x64,0x61,0x62,0x73,0x70,0x75,0x76,0x7f,0x7c,0x79,0x7a,
            0x3b,0x38,0x3d,0x3e,0x37,0x34,0x31,0x32,0x23,0x20,0x25,0x26,0x2f,0x2c,0x29,0x2a,
            0x0b,0x08,0x0d,0x0e,0x07,0x04,0x01,0x02,0x13,0x10,0x15,0x16,0x1f,0x1c,0x19,0x1a
    };

    static int[] table9={
            0x00,0x09,0x12,0x1b,0x24,0x2d,0x36,0x3f,0x48,0x41,0x5a,0x53,0x6c,0x65,0x7e,0x77,
            0x90,0x99,0x82,0x8b,0xb4,0xbd,0xa6,0xaf,0xd8,0xd1,0xca,0xc3,0xfc,0xf5,0xee,0xe7,
            0x3b,0x32,0x29,0x20,0x1f,0x16,0x0d,0x04,0x73,0x7a,0x61,0x68,0x57,0x5e,0x45,0x4c,
            0xab,0xa2,0xb9,0xb0,0x8f,0x86,0x9d,0x94,0xe3,0xea,0xf1,0xf8,0xc7,0xce,0xd5,0xdc,
            0x76,0x7f,0x64,0x6d,0x52,0x5b,0x40,0x49,0x3e,0x37,0x2c,0x25,0x1a,0x13,0x08,0x01,
            0xe6,0xef,0xf4,0xfd,0xc2,0xcb,0xd0,0xd9,0xae,0xa7,0xbc,0xb5,0x8a,0x83,0x98,0x91,
            0x4d,0x44,0x5f,0x56,0x69,0x60,0x7b,0x72,0x05,0x0c,0x17,0x1e,0x21,0x28,0x33,0x3a,
            0xdd,0xd4,0xcf,0xc6,0xf9,0xf0,0xeb,0xe2,0x95,0x9c,0x87,0x8e,0xb1,0xb8,0xa3,0xaa,
            0xec,0xe5,0xfe,0xf7,0xc8,0xc1,0xda,0xd3,0xa4,0xad,0xb6,0xbf,0x80,0x89,0x92,0x9b,
            0x7c,0x75,0x6e,0x67,0x58,0x51,0x4a,0x43,0x34,0x3d,0x26,0x2f,0x10,0x19,0x02,0x0b,
            0xd7,0xde,0xc5,0xcc,0xf3,0xfa,0xe1,0xe8,0x9f,0x96,0x8d,0x84,0xbb,0xb2,0xa9,0xa0,
            0x47,0x4e,0x55,0x5c,0x63,0x6a,0x71,0x78,0x0f,0x06,0x1d,0x14,0x2b,0x22,0x39,0x30,
            0x9a,0x93,0x88,0x81,0xbe,0xb7,0xac,0xa5,0xd2,0xdb,0xc0,0xc9,0xf6,0xff,0xe4,0xed,
            0x0a,0x03,0x18,0x11,0x2e,0x27,0x3c,0x35,0x42,0x4b,0x50,0x59,0x66,0x6f,0x74,0x7d,
            0xa1,0xa8,0xb3,0xba,0x85,0x8c,0x97,0x9e,0xe9,0xe0,0xfb,0xf2,0xcd,0xc4,0xdf,0xd6,
            0x31,0x38,0x23,0x2a,0x15,0x1c,0x07,0x0e,0x79,0x70,0x6b,0x62,0x5d,0x54,0x4f,0x46
    };

    static int[] table11={
            0x00,0x0b,0x16,0x1d,0x2c,0x27,0x3a,0x31,0x58,0x53,0x4e,0x45,0x74,0x7f,0x62,0x69,
            0xb0,0xbb,0xa6,0xad,0x9c,0x97,0x8a,0x81,0xe8,0xe3,0xfe,0xf5,0xc4,0xcf,0xd2,0xd9,
            0x7b,0x70,0x6d,0x66,0x57,0x5c,0x41,0x4a,0x23,0x28,0x35,0x3e,0x0f,0x04,0x19,0x12,
            0xcb,0xc0,0xdd,0xd6,0xe7,0xec,0xf1,0xfa,0x93,0x98,0x85,0x8e,0xbf,0xb4,0xa9,0xa2,
            0xf6,0xfd,0xe0,0xeb,0xda,0xd1,0xcc,0xc7,0xae,0xa5,0xb8,0xb3,0x82,0x89,0x94,0x9f,
            0x46,0x4d,0x50,0x5b,0x6a,0x61,0x7c,0x77,0x1e,0x15,0x08,0x03,0x32,0x39,0x24,0x2f,
            0x8d,0x86,0x9b,0x90,0xa1,0xaa,0xb7,0xbc,0xd5,0xde,0xc3,0xc8,0xf9,0xf2,0xef,0xe4,
            0x3d,0x36,0x2b,0x20,0x11,0x1a,0x07,0x0c,0x65,0x6e,0x73,0x78,0x49,0x42,0x5f,0x54,
            0xf7,0xfc,0xe1,0xea,0xdb,0xd0,0xcd,0xc6,0xaf,0xa4,0xb9,0xb2,0x83,0x88,0x95,0x9e,
            0x47,0x4c,0x51,0x5a,0x6b,0x60,0x7d,0x76,0x1f,0x14,0x09,0x02,0x33,0x38,0x25,0x2e,
            0x8c,0x87,0x9a,0x91,0xa0,0xab,0xb6,0xbd,0xd4,0xdf,0xc2,0xc9,0xf8,0xf3,0xee,0xe5,
            0x3c,0x37,0x2a,0x21,0x10,0x1b,0x06,0x0d,0x64,0x6f,0x72,0x79,0x48,0x43,0x5e,0x55,
            0x01,0x0a,0x17,0x1c,0x2d,0x26,0x3b,0x30,0x59,0x52,0x4f,0x44,0x75,0x7e,0x63,0x68,
            0xb1,0xba,0xa7,0xac,0x9d,0x96,0x8b,0x80,0xe9,0xe2,0xff,0xf4,0xc5,0xce,0xd3,0xd8,
            0x7a,0x71,0x6c,0x67,0x56,0x5d,0x40,0x4b,0x22,0x29,0x34,0x3f,0x0e,0x05,0x18,0x13,
            0xca,0xc1,0xdc,0xd7,0xe6,0xed,0xf0,0xfb,0x92,0x99,0x84,0x8f,0xbe,0xb5,0xa8,0xa3
    };

    static int[] table13={
            0x00,0x0d,0x1a,0x17,0x34,0x39,0x2e,0x23,0x68,0x65,0x72,0x7f,0x5c,0x51,0x46,0x4b,
            0xd0,0xdd,0xca,0xc7,0xe4,0xe9,0xfe,0xf3,0xb8,0xb5,0xa2,0xaf,0x8c,0x81,0x96,0x9b,
            0xbb,0xb6,0xa1,0xac,0x8f,0x82,0x95,0x98,0xd3,0xde,0xc9,0xc4,0xe7,0xea,0xfd,0xf0,
            0x6b,0x66,0x71,0x7c,0x5f,0x52,0x45,0x48,0x03,0x0e,0x19,0x14,0x37,0x3a,0x2d,0x20,
            0x6d,0x60,0x77,0x7a,0x59,0x54,0x43,0x4e,0x05,0x08,0x1f,0x12,0x31,0x3c,0x2b,0x26,
            0xbd,0xb0,0xa7,0xaa,0x89,0x84,0x93,0x9e,0xd5,0xd8,0xcf,0xc2,0xe1,0xec,0xfb,0xf6,
            0xd6,0xdb,0xcc,0xc1,0xe2,0xef,0xf8,0xf5,0xbe,0xb3,0xa4,0xa9,0x8a,0x87,0x90,0x9d,
            0x06,0x0b,0x1c,0x11,0x32,0x3f,0x28,0x25,0x6e,0x63,0x74,0x79,0x5a,0x57,0x40,0x4d,
            0xda,0xd7,0xc0,0xcd,0xee,0xe3,0xf4,0xf9,0xb2,0xbf,0xa8,0xa5,0x86,0x8b,0x9c,0x91,
            0x0a,0x07,0x10,0x1d,0x3e,0x33,0x24,0x29,0x62,0x6f,0x78,0x75,0x56,0x5b,0x4c,0x41,
            0x61,0x6c,0x7b,0x76,0x55,0x58,0x4f,0x42,0x09,0x04,0x13,0x1e,0x3d,0x30,0x27,0x2a,
            0xb1,0xbc,0xab,0xa6,0x85,0x88,0x9f,0x92,0xd9,0xd4,0xc3,0xce,0xed,0xe0,0xf7,0xfa,
            0xb7,0xba,0xad,0xa0,0x83,0x8e,0x99,0x94,0xdf,0xd2,0xc5,0xc8,0xeb,0xe6,0xf1,0xfc,
            0x67,0x6a,0x7d,0x70,0x53,0x5e,0x49,0x44,0x0f,0x02,0x15,0x18,0x3b,0x36,0x21,0x2c,
            0x0c,0x01,0x16,0x1b,0x38,0x35,0x22,0x2f,0x64,0x69,0x7e,0x73,0x50,0x5d,0x4a,0x47,
            0xdc,0xd1,0xc6,0xcb,0xe8,0xe5,0xf2,0xff,0xb4,0xb9,0xae,0xa3,0x80,0x8d,0x9a,0x97
    };

    static int[] table14={
            0x00,0x0e,0x1c,0x12,0x38,0x36,0x24,0x2a,0x70,0x7e,0x6c,0x62,0x48,0x46,0x54,0x5a,
            0xe0,0xee,0xfc,0xf2,0xd8,0xd6,0xc4,0xca,0x90,0x9e,0x8c,0x82,0xa8,0xa6,0xb4,0xba,
            0xdb,0xd5,0xc7,0xc9,0xe3,0xed,0xff,0xf1,0xab,0xa5,0xb7,0xb9,0x93,0x9d,0x8f,0x81,
            0x3b,0x35,0x27,0x29,0x03,0x0d,0x1f,0x11,0x4b,0x45,0x57,0x59,0x73,0x7d,0x6f,0x61,
            0xad,0xa3,0xb1,0xbf,0x95,0x9b,0x89,0x87,0xdd,0xd3,0xc1,0xcf,0xe5,0xeb,0xf9,0xf7,
            0x4d,0x43,0x51,0x5f,0x75,0x7b,0x69,0x67,0x3d,0x33,0x21,0x2f,0x05,0x0b,0x19,0x17,
            0x76,0x78,0x6a,0x64,0x4e,0x40,0x52,0x5c,0x06,0x08,0x1a,0x14,0x3e,0x30,0x22,0x2c,
            0x96,0x98,0x8a,0x84,0xae,0xa0,0xb2,0xbc,0xe6,0xe8,0xfa,0xf4,0xde,0xd0,0xc2,0xcc,
            0x41,0x4f,0x5d,0x53,0x79,0x77,0x65,0x6b,0x31,0x3f,0x2d,0x23,0x09,0x07,0x15,0x1b,
            0xa1,0xaf,0xbd,0xb3,0x99,0x97,0x85,0x8b,0xd1,0xdf,0xcd,0xc3,0xe9,0xe7,0xf5,0xfb,
            0x9a,0x94,0x86,0x88,0xa2,0xac,0xbe,0xb0,0xea,0xe4,0xf6,0xf8,0xd2,0xdc,0xce,0xc0,
            0x7a,0x74,0x66,0x68,0x42,0x4c,0x5e,0x50,0x0a,0x04,0x16,0x18,0x32,0x3c,0x2e,0x20,
            0xec,0xe2,0xf0,0xfe,0xd4,0xda,0xc8,0xc6,0x9c,0x92,0x80,0x8e,0xa4,0xaa,0xb8,0xb6,
            0x0c,0x02,0x10,0x1e,0x34,0x3a,0x28,0x26,0x7c,0x72,0x60,0x6e,0x44,0x4a,0x58,0x56,
            0x37,0x39,0x2b,0x25,0x0f,0x01,0x13,0x1d,0x47,0x49,0x5b,0x55,0x7f,0x71,0x63,0x6d,
            0xd7,0xd9,0xcb,0xc5,0xef,0xe1,0xf3,0xfd,0xa7,0xa9,0xbb,0xb5,0x9f,0x91,0x83,0x8d
    };

    public static int subWord(int input,int[] sbox){
        //input has to be 4-byte long
        int output=0x0;
        for(int i=0;i<4;i++){
            int row=(int) (input>>(28-i*8))&0x0f;
            int col=(int) (input>>(24-i*8))&0x0f;
            output|=s[16*row+col]<<(24-i*8);

        }
        return output;

    }

    public static byte SubByte(byte inputbyte){

        int row=(inputbyte>>4)&0xf;
        int col=inputbyte&0xf;
        return (byte) s[16*row+col];

    }

    public static byte invSubByte(byte inputbyte){

        int row=(inputbyte>>4)&0xf;
        int col=inputbyte&0xf;
        return (byte) invs[16*row+col];

    }

    public static byte[] subByte(byte[] bytearray){
        byte[] output=new byte[bytearray.length];
        for(int i=0;i<bytearray.length;i++)
            output[i]=SubByte(bytearray[i]);

        return output;

    }

    public static byte[] invSubByte(byte[] bytearray){
        byte[] output=new byte[bytearray.length];
        for(int i=0;i<bytearray.length;i++)
            output[i]=invSubByte(bytearray[i]);

        return output;

    }


    public static int rotWord(int input){

        return (input<<8)|((input>>24)&0xff);
    }

    public static int Rcon(int i){
        int rcon=1;
        for (int j=0;j<(i-1);j++){
            rcon=(rcon<<1) ^ (0x11b & -(rcon>>7));
        }

        return rcon<<24;
    }

    public static byte[][] keyExpansion(int Nk, int Nb, int Nr,byte[] key){ //Nk is number of 32-bit words of cipher key ,Nb is num of column
        int keyLength=key.length;
        int[] output=new int[Nb*(Nr+1)];
        if(keyLength!=4*Nk){
            System.out.println("key length is incorrect!");
            System.exit(0);
        }
        //merge number Nk of key in 32-bit word format
        int temp;
        for(int i=0;i<Nk;i++){
            output[i]=(key[4*i]&0xff)<<24 | (key[4*i+1]&0xff)<<16 | (key[4*i+2]&0xff)<<8 | (key[4*i+3]&0xff)<<0;
        }

        for(int i=Nk;i<Nb*(Nr+1);i++){
            temp=output[i-1];

            if(i%Nk==0){
                int afterRot=rotWord(temp);
                int afterSub = subWord(afterRot,s);
                int Rocon=Rcon(i/Nk);
                temp=afterSub ^ Rocon;
            }
            else if((Nk > 6) &&(i%Nk==4)){
                temp=subWord(temp,s);
            }
            output[i]=output[i-Nk] ^ temp;
        }

        //convert long to byte[]
        byte[][] outputByte=new byte[output.length/4][16];
        int k=0;
        for (int i=0;i<output.length/4;i++){


            for(int j=0;j<4;j++){
                int tempInt=output[k++];
                outputByte[i][j*4]=(byte) (0xff&(tempInt>>24));
                outputByte[i][j*4+1]=(byte) (0xff&(tempInt>>16));
                outputByte[i][j*4+2]=(byte) (0xff&(tempInt>>8));
                outputByte[i][j*4+3]=(byte) (0xff&(tempInt>>0));
            }
        }

        return outputByte;


    }



    public static void testsubByte(){
        //byte x=(byte) 0x53;
        //byte y=SubByte(x);
        //System.out.println(Integer.toHexString(y&0xff));

        byte[] input;
        input=hexStringToByteArray("193de3bea0f4e22b9ac68d2ae9f84808");
        input=subByte(input);

        System.out.println(bytesToHex(input));
    }

    public static void testinvSubByte(){
        //byte x=(byte) 0x53;
        //byte y=SubByte(x);
        //System.out.println(Integer.toHexString(y&0xff));

        byte[] input;
        input=hexStringToByteArray("D42711AEE0BF98F1B8B45DE51E415230");
        input=invSubByte(input);

        System.out.println(bytesToHex(input));
    }

    public static int shiftRows(int input,int steps){
        if(steps>3|steps<0){
            System.out.println("wrong steps");
            System.exit(0);
        }

        int output=(input<<(steps*8)) | ((input>>>(32-steps*8)));

        return output;
    }

    public static int invShiftRows(int input,int steps){
        if(steps>3|steps<0){
            System.out.println("wrong steps");
            System.exit(0);
        }

        int output=(input>>>(steps*8)) | ((input<<(32-steps*8)));

        return output;
    }

    static public long byte2long(byte[] mybyte,int bytelength){
        long result=0x0l;
        for(int i=0;i<bytelength;i++){
            result|=(mybyte[i]&0xffl)<<(bytelength*8-i*8-8);
        }
        return result;
    }

    static public byte[] long2byte(long input,int bytelength){
        byte[] bits = new byte[bytelength];
        for (int i=0;i<bytelength;i++){
            bits[i]=(byte) ((input>>(bytelength*8-i*8-8))&0xffl);
        }
        return bits;
    }

    static byte[] shift4Rows(byte[] input){ //input is 4 row, 16 bytes
        int temp;
        for (int i=0;i<4;i++){
            temp=(input[i]&0xff)<<24 | (0xff&input[i+4])<<16 | (0xff&input[i+8])<<8 | input[i+12]&0xff;
            temp=shiftRows(temp,i);
            input[i]=(byte) ((temp>>>24)&0xff);
            input[i+4]=(byte) ((temp>>>16)&0xff);
            input[i+8]=(byte) ((temp>>>8)&0xff);
            input[i+12]=(byte) (temp&0xff);
        }
        return input;

    }
    static byte[] invShift4Rows(byte[] input){ //input is 4 row, 16 bytes
        int temp;
        for (int i=0;i<4;i++){
            temp=(input[i]&0xff)<<24 | (0xff&input[i+4])<<16 | (0xff&input[i+8])<<8 | input[i+12]&0xff;
            temp=invShiftRows(temp,i);
            input[i]=(byte) ((temp>>>24)&0xff);
            input[i+4]=(byte) ((temp>>>16)&0xff);
            input[i+8]=(byte) ((temp>>>8)&0xff);
            input[i+12]=(byte) (temp&0xff);
        }
        return input;

    }


    public static void testshiftrow(){
        int temp=0x12abcdef;
        int a=shiftRows(temp,0);
        int b=shiftRows(temp,1);
        int c=shiftRows(temp,2);
        int d=shiftRows(temp,3);
        System.out.println(Integer.toHexString(a));
        System.out.println(Integer.toHexString(b));
        System.out.println(Integer.toHexString(c));
        System.out.println(Integer.toHexString(d));

    }

    public static void testshift4row(){
        byte[] input;
        input=hexStringToByteArray("d42711aee0bf98f1b8b45de51e415230");
        input=shift4Rows(input);

        System.out.println(bytesToHex(input));

        int test=shiftRows(0x19a09ae9,1);
        System.out.println(Integer.toHexString(test));
    }

    public static void invTestshift4row(){
        byte[] input;
        input=hexStringToByteArray("D4BF5D30E0B452AEB84111F11E2798E5");
        input=invShift4Rows(input);

        System.out.println(bytesToHex(input));

    }

    public static void testinvShift4row(){
        byte[] input;
        input=hexStringToByteArray("d42711aee0bf98f1b8b45de51e415230");
        input=shift4Rows(input);

        System.out.println(bytesToHex(input));

        int test=shiftRows(0x19a09ae9,1);
        System.out.println(Integer.toHexString(test));
    }

    public static String bytesToHex(byte[] bytes) {
        char[] hexArray = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for ( int j = 0; j < bytes.length; j++ ) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static byte FFmul( byte a, byte b){
        byte aa=a,bb=b,r=0,t;
        while(aa!=0){
            if((aa&1)!=0)
                r=(byte) (r ^ bb);
            t=(byte)(bb & 0x80);
            bb=(byte)(bb<<1);
            if(t!=0)
                bb=(byte)(bb^0x1b);
            aa=(byte)(aa>>1);
        }
        return r;
    }


    public static byte[] mixColumns(byte[] input){
        byte[] output=new byte[16];
        for(int i=0;i<4;i++){
            output[4*i]=(byte) ((FFmul((byte)0x02,input[4*i]))^(FFmul((byte)0x03,input[4*i+1]))^(input[4*i+2])^(input[4*i+3]));
            output[4*i+1]=(byte) ((FFmul((byte)0x02,input[4*i+1]))^(FFmul((byte)0x03,input[4*i+2]))^(input[4*i])^(input[4*i+3]));
            output[4*i+2]=(byte) ((FFmul((byte)0x02,input[4*i+2]))^(FFmul((byte)0x03,input[4*i+3]))^(input[4*i+1])^(input[4*i]));
            output[4*i+3]=(byte) ((FFmul((byte)0x02,input[4*i+3]))^(FFmul((byte)0x03,input[4*i]))^(input[4*i+1])^(input[4*i+2]));
        }

        return output;
    }

    public static byte[] mixOptiColumns(byte[] input){
        byte[] output=new byte[16];
        for(int i=0;i<4;i++){
            output[4*i]=(byte) ((Gmul((byte)0x02,input[4*i]))^(Gmul((byte)0x03,input[4*i+1]))^(Gmul((byte)0x01,input[4*i+2]))^(Gmul((byte)0x01,input[4*i+3])));
            output[4*i+1]=(byte) ((Gmul((byte)0x01,input[4*i]))^(Gmul((byte)0x02,input[4*i+1]))^(Gmul((byte)0x03,input[4*i+2]))^(Gmul((byte)0x01,input[4*i+3])));
            output[4*i+2]=(byte) ((Gmul((byte)0x01,input[4*i]))^(Gmul((byte)0x01,input[4*i+1]))^(Gmul((byte)0x02,input[4*i+2]))^(Gmul((byte)0x03,input[4*i+3])));
            output[4*i+3]=(byte) ((Gmul((byte)0x03,input[4*i]))^(Gmul((byte)0x01,input[4*i+1]))^(Gmul((byte)0x01,input[4*i+2]))^(Gmul((byte)0x02,input[4*i+3])));
        }

        return output;
    }

    public static int Gmul(int t,int p){
        t=t&0xff;
        p=p&0xff;
        switch(t){
            case 1:
                return p;
            case 2:
                return table2[p];
            case 3:
                return table3[p];
            case 9:
                return table9[p];
            case 11:
                return table11[p];
            case 13:
                return table13[p];
            case 14:
                return table14[p];
            default:
                return 0;
        }

    }



    public static byte[] invMixColumns(byte[] input){
        byte[] output=new byte[16];
        for(int i=0;i<4;i++){
            output[4*i]=(byte) ((FFmul((byte)0x0e,input[4*i]))^(FFmul((byte)0x0b,input[4*i+1]))^(FFmul((byte)0x0d,input[4*i+2]))^(FFmul((byte)0x09,input[4*i+3])));
            output[4*i+1]=(byte) ((FFmul((byte)0x09,input[4*i]))^(FFmul((byte)0x0e,input[4*i+1]))^(FFmul((byte)0x0b,input[4*i+2]))^(FFmul((byte)0x0d,input[4*i+3])));
            output[4*i+2]=(byte) ((FFmul((byte)0x0d,input[4*i]))^(FFmul((byte)0x09,input[4*i+1]))^(FFmul((byte)0x0e,input[4*i+2]))^(FFmul((byte)0x0b,input[4*i+3])));
            output[4*i+3]=(byte) ((FFmul((byte)0x0b,input[4*i]))^(FFmul((byte)0x0d,input[4*i+1]))^(FFmul((byte)0x09,input[4*i+2]))^(FFmul((byte)0x0e,input[4*i+3])));
        }

        return output;
    }

    public static byte[] invOptiMixColumns(byte[] input){
        byte[] output=new byte[16];
        for(int i=0;i<4;i++){
            output[4*i]=(byte) ((Gmul((byte)0x0e,input[4*i]))^(Gmul((byte)0x0b,input[4*i+1]))^(Gmul((byte)0x0d,input[4*i+2]))^(Gmul((byte)0x09,input[4*i+3])));
            output[4*i+1]=(byte) ((Gmul((byte)0x09,input[4*i]))^(Gmul((byte)0x0e,input[4*i+1]))^(Gmul((byte)0x0b,input[4*i+2]))^(Gmul((byte)0x0d,input[4*i+3])));
            output[4*i+2]=(byte) ((Gmul((byte)0x0d,input[4*i]))^(Gmul((byte)0x09,input[4*i+1]))^(Gmul((byte)0x0e,input[4*i+2]))^(Gmul((byte)0x0b,input[4*i+3])));
            output[4*i+3]=(byte) ((Gmul((byte)0x0b,input[4*i]))^(Gmul((byte)0x0d,input[4*i+1]))^(Gmul((byte)0x09,input[4*i+2]))^(Gmul((byte)0x0e,input[4*i+3])));
        }

        return output;
    }



    public static byte[] addRoundKey(byte[] key,byte[] input){
        byte[] output=new byte[16];
        for(int i=0;i<4;i++){
            output[4*i]=(byte) (input[4*i]^key[4*i]);
            output[4*i+1]=(byte) (input[4*i+1]^key[4*i+1]);
            output[4*i+2]=(byte) (input[4*i+2]^key[4*i+2]);
            output[4*i+3]=(byte) (input[4*i+3]^key[4*i+3]);
        }
        return output;

    }
    public static void testAddRoundKey(){

        byte[] input=hexStringToByteArray("046681E5E0CB199A48F8D37A2806264C");
        byte[] key=hexStringToByteArray("a0fafe1788542cb123a339392a6c7605");
        byte[] output=addRoundKey(key,input);

        System.out.println(bytesToHex(output));
    }



    public static void testMixColumns(){


        byte xx=FFmul((byte) 0x3,(byte) 0xbf);;
        System.out.println(xx);
        System.out.println(Integer.toHexString(xx));

        byte[] input;
        input=hexStringToByteArray("D4BF5D30E0B452AEB84111F11E2798E5");
        byte[] output=mixOptiColumns(input);
        System.out.println(bytesToHex(output));
    }

    public static void testinvMixColumns(){


        byte xx=FFmul((byte) 0x3,(byte) 0xbf);;
        System.out.println(xx);
        System.out.println(Integer.toHexString(xx));

        byte[] input;
        input=hexStringToByteArray("046681E5E0CB199A48F8D37A2806264C");
        byte[] output=invOptiMixColumns(input);
        System.out.println(bytesToHex(output));
    }


    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }


    public static byte[] encryptBlockECB(byte[] blk,byte[] masterkey,int Nb,int Nr,int Nk){
        byte[][] ks=keyExpansion(Nk,Nb,Nr,masterkey);
        int length = blk.length,start=0,end=16;
        byte[] block=new byte[(length/16)*16+16];
        byte[] temp = new byte[16];
        for(int i=0;i<blk.length/16;i++){
            temp=Arrays.copyOfRange(blk, start,end);
            start+=16;
            end+=16;
            length-=16;
            temp=encryptBlock(temp,ks,Nr);

            for(int j=0;j<16;j++){
                block[16*i+j]=temp[j];
            }

        }

        //check padding

        //padding other values
        int pad=16-length%16;
        temp=Arrays.copyOfRange(blk, start,end);
        for(int i=0;i<pad;i++){
            temp[15-i]=(byte)pad;
        }

        //encrypt
        temp=encryptBlock(temp,ks,Nr);
        for(int j=0;j<16;j++){
            block[block.length-j-1]=temp[15-j];
        }


        return block;

    }

    public static byte[] logicalXOR(byte[] a, byte[] b){
        if(a.length!=b.length){
            System.out.println("a, b length unmatch");
            System.exit(0);
        }

        for(int i=0;i<a.length;i++){
            a[i]=(byte) (a[i]^b[i]);
        }
        return a;
    }



    public static byte[] encryptBlockCBC(byte[] iv,byte[] blk,byte[] masterkey,int Nb,int Nr,int Nk){
        byte[][] ks=keyExpansion(Nk,Nb,Nr,masterkey);

        int length = blk.length,start=0,end=16;
        byte[] block=new byte[(int) Math.ceil(((double)length)/16)*16];
        byte[] temp = new byte[16];

        for(int i=0;i<blk.length/16;i++){
            temp=Arrays.copyOfRange(blk, start,end);
            start+=16;
            end+=16;
            length-=16;
            temp=logicalXOR(temp,iv);
            temp=encryptBlock(temp,ks,Nr);
            iv=temp;
            for(int j=0;j<16;j++){
                block[16*i+j]=temp[j];
            }

        }

        //check padding

        //padding other values
        int pad=16-length%16;
        temp=Arrays.copyOfRange(block, start,end);
        for(int i=0;i<pad;i++){
            temp[15-i]=(byte)pad;
        }

        //encrypt
        temp=logicalXOR(temp,iv);
        temp=encryptBlock(temp,ks,Nr);
        for(int j=0;j<16;j++){
            block[block.length-j-1]=temp[15-j];
        }



        return block;

    }


    public static byte[] decryptBlockECB(byte[] block,byte[] masterkey,int Nb,int Nr,int Nk){
        byte[][] ks=keyExpansion(Nk,Nb,Nr,masterkey);
        int start=0,end=16;

        byte[] temp = new byte[16];
        for(int i=0;i<block.length/16;i++){
            temp=Arrays.copyOfRange(block, start,end);
            start+=16;
            end+=16;
            temp=decryptBlock(temp,ks,Nr);

            for(int j=0;j<16;j++){
                block[16*i+j]=temp[j];
            }

        }

        //check padding by examing last byte
        int pad=block[block.length-1];
        return 	Arrays.copyOf(block, block.length-pad);

    }

    public static byte[] decryptBlockCBC(byte[] iv,byte[] block,byte[] masterkey,int Nb,int Nr,int Nk){
        byte[][] ks=keyExpansion(Nk,Nb,Nr,masterkey);
        int start=0,end=16;

        byte[] temp = new byte[16];
        byte[] ivtemp = new byte[16];
        for(int i=0;i<block.length/16;i++){
            temp=Arrays.copyOfRange(block, start,end);
            start+=16;
            end+=16;
            ivtemp=temp;
            temp=decryptBlock(temp,ks,Nr);
            temp=logicalXOR(temp,iv);
            iv=ivtemp;
            for(int j=0;j<16;j++){
                block[16*i+j]=temp[j];
            }

        }

        //check padding by examing last byte
        int pad=block[block.length-1];
        return 	Arrays.copyOf(block, block.length-pad);

    }



    public static byte[] encryptBlock(byte[] block,byte[][] ks,int Nr){

        //1st
        byte[] input=addRoundKey(ks[0],block);
        for(int i=1;i<Nr;i++){

            input=subByte(input);
            input=shift4Rows(input);
            input=mixColumns(input);
            input=addRoundKey(ks[i],input);
        }
        input=subByte(input);
        input=shift4Rows(input);
        input=addRoundKey(ks[Nr],input);
        return input;
    }

    public static byte[] decryptBlock(byte[] block,byte[][] ks,int Nr){

        //1st
        byte[] input=addRoundKey(ks[Nr],block);
        for(int i=Nr-1;i>0;i--){
            input=invShift4Rows(input);
            input=invSubByte(input);
            input=addRoundKey(ks[i],input);
            input=invMixColumns(input);

        }
        input=invSubByte(input);
        input=invShift4Rows(input);
        input=addRoundKey(ks[0],input);
        return input;
    }

    public static void encryptFile(String inputFile,String outputFile,byte[] masterkey,int Nb,int Nk,int Nr,byte[] iv,String encryptMode) throws IOException{
        String currentFolder= System.getProperty("user.dir");
        FileInputStream fileIn=new FileInputStream(new File(currentFolder+"/"+inputFile));
        FileOutputStream fileOut=new FileOutputStream(currentFolder+"/"+outputFile);

        int lengthFile=(int) fileIn.getChannel().size(); //file couldn't exceed 4G
        byte[] bits= new byte[lengthFile];
        fileIn.read(bits);
        switch(encryptMode){
            case "ECB":
                byte[] outputECB=encryptBlockECB(bits,masterkey,Nb,Nr,Nk);
                fileOut.write(outputECB);
                fileOut.close();
                fileIn.close();
                break;
            case "CBC":
                byte[] outputCBC=encryptBlockCBC(iv,bits,masterkey,Nb,Nr,Nk);
                fileOut.write(outputCBC);
                fileOut.close();
                fileIn.close();
                break;
            default:
                break;
        }


    }

    public static void decryptFile(String inputFile,String outputFile,byte[] masterkey,int Nb,int Nk,int Nr,byte[] iv,String encryptMode) throws IOException{
        String currentFolder= System.getProperty("user.dir");
        FileInputStream fileIn=new FileInputStream(new File(currentFolder+"/"+inputFile));
        FileOutputStream fileOut=new FileOutputStream(currentFolder+"/"+outputFile);

        int lengthFile=(int) fileIn.getChannel().size(); //file couldn't exceed 4G
        byte[] bits= new byte[lengthFile];
        fileIn.read(bits);


        switch(encryptMode){
            case "ECB":

                byte[] outputECB=decryptBlockECB(bits,masterkey,Nb,Nr,Nk);

                fileOut.write(outputECB);
                fileOut.close();
                fileIn.close();
                break;
            case "CBC":
                byte[] outputCBC=decryptBlockCBC(iv,bits,masterkey,Nb,Nr,Nk);
                fileOut.write(outputCBC);
                fileOut.close();
                fileIn.close();
                break;
            default:
                break;
        }


    }



    public static void testencryptECB(){

        byte[] cipherkey=hexStringToByteArray("000102030405060708090a0b0c0d0e0f1011121314151617");
        byte[] block=hexStringToByteArray("00112233445566778899aabbccddeeff00112233445566778899aabbccddeeff");
        byte[] result =encryptBlockECB(block,cipherkey,4,12,6);
        System.out.println(bytesToHex(result));
    }



    public static void testencryptCBC(){

        byte[] cipherkey=hexStringToByteArray("2b7e151628aed2a6abf7158809cf4f3c");
        byte[] block=hexStringToByteArray("3243F6A8885A308D313198A2E037073400");
        byte[] iv=hexStringToByteArray("00112233445566778899aabbccddeeff");

        byte[] result2 =encryptBlockCBC(iv,block,cipherkey,4,10,4);
        System.out.println(bytesToHex(result2));
    }

    public static void testdecryptECB(){

        byte[] cipherkey=hexStringToByteArray("000102030405060708090a0b0c0d0e0f1011121314151617");
        byte[] block=hexStringToByteArray("DDA97CA4864CDFE06EAF70A0EC0D7191DDA97CA4864CDFE06EAF70A0EC0D71913FE7286ABDE5F03943D5777020259626");
        byte[] result =decryptBlockECB(block,cipherkey,4,12,6);
        System.out.println(bytesToHex(result));
    }




    public static void testdecryptCBC(){

        byte[] cipherkey=hexStringToByteArray("2b7e151628aed2a6abf7158809cf4f3c");
        byte[] iv=hexStringToByteArray("00112233445566778899aabbccddeeff");
        byte[] block=hexStringToByteArray("9B413D5A34EF797CE0AD20C6125C807548CA804321E2E4959B2A71D108165AC8");
        byte[] result =decryptBlockCBC(iv,block,cipherkey,4,10,4);
        System.out.println(bytesToHex(result));
    }



    public static void testkeyexpansion(){

        int interim=rotWord(0x09cf4f3c);
        int aftersubword=subWord(interim,s);
        System.out.println(interim);
        System.out.println(aftersubword);
        System.out.println("ron"+"1="+Integer.toHexString(Rcon(1)));
        System.out.println("ron"+"2="+Integer.toHexString(Rcon(2)));
        System.out.println("ron"+"3="+Integer.toHexString(Rcon(3)));
        System.out.println("ron"+"4="+Integer.toHexString(Rcon(4)));
        System.out.println("ron"+"5="+Integer.toHexString(Rcon(5)));
        System.out.println("ron"+"6="+Integer.toHexString(Rcon(6)));
        System.out.println("ron"+"7="+Integer.toHexString(Rcon(7)));
        System.out.println("ron"+"8="+Integer.toHexString(Rcon(8)));
        System.out.println("ron"+"9="+Integer.toHexString(Rcon(9)));
        System.out.println("ron"+"10="+Integer.toHexString(Rcon(10)));
        byte[] cipherkey=hexStringToByteArray("603deb1015ca71be2b73aef0857d77811f352c073b6108d72d9810a30914dff4");
        byte[][] ks=keyExpansion(8,4,14,cipherkey);
        System.out.println("length"+ks.length);
        System.out.println("***************");
        for(byte i:ks[14])
            System.out.println(Integer.toHexString(i));
    }

    public static void main(String[] args) throws IOException{

        if(args.length!=9){
            System.out.println("error: input format is inputfile, outputfile,key,Nb,Nr,Nk,Iv,operationMode,encrypt/decrypt");
            System.exit(0);
        }


        String inputFile=args[0];
        String outputFile=args[1];
        byte[] masterkey=hexStringToByteArray(args[2]);
        int Nb=Integer.parseInt(args[3]);
        int Nr=Integer.parseInt(args[4]);
        int Nk=Integer.parseInt(args[5]);
        byte[] iv=hexStringToByteArray(args[6]);
        String encryptMode=args[7];
        String Mode=args[8];
        long startTime = System.nanoTime();
        switch(Mode){
            case "encrypt":
                encryptFile( inputFile, outputFile,masterkey, Nb, Nk, Nr,iv, encryptMode);
                long difference1 = System.nanoTime() - startTime;
                System.out.println("Total execution time: " +
                        String.format(" %d sec",
                                TimeUnit.NANOSECONDS.toSeconds(difference1)));
                System.out.println("encrypted!");
                break;
            case "decrypt":
                decryptFile( inputFile, outputFile,masterkey, Nb, Nk, Nr,iv, encryptMode);
                long difference2 = System.nanoTime() - startTime;
                System.out.println("Total execution time: " +
                        String.format("%d sec",
                                TimeUnit.NANOSECONDS.toSeconds(difference2)));

                System.out.println("decrypted!");
                break;
            default:
                break;

        }


        /**
         //testkeyexpansion();
         //testsubByte();
         //testshiftrow();
         //testMixColumns();
         //testAddRoundKey();
         //testencryptECB();
         //invTestshift4row();
         testinvMixColumns();

         //testinvSubByte();
         //	testencryptECB();
         //testencryptCBC();
         //testdecryptCBC();
         //testdecryptECB();
         */
    }


}
