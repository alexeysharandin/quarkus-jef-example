<template>
    <v-card class="mx-auto my-12" max-width="250" :loading="loading" height="100%">
        <v-img height="200" src="/flash.png"></v-img>
        <v-card-title>SPI Flash Memory</v-card-title>
        <v-card-text>
            Stored data:
        </v-card-text>
        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn icon @click="on">
                <v-icon dark>mdi-content-save-all</v-icon>
            </v-btn>
            <v-btn icon @click="off">
                <v-icon dark>mdi-file-upload-outline</v-icon>
            </v-btn>
        </v-card-actions>
    </v-card>
</template>

<script src="./SpiFlashWidget.js"></script>