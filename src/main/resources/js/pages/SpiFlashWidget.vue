<template>
    <v-card class="mx-auto my-12" max-width="230" height="100%">
        <v-img height="200" src="/flash.png"></v-img>
        <v-card-title>SPI Flash Memory</v-card-title>
        <v-card-text>
            <template v-if="stored && stored.lux">
                Stored data:
                <v-row>
                    <v-col>lux:</v-col>
                    <v-col>{{stored.lux.toFixed(2)}}</v-col>
                </v-row>
                <v-row>
                    <v-col>gpio:</v-col>
                    <v-col>{{stored.gpio}}</v-col>
                </v-row>
                <v-row>
                    <v-col>longitude:</v-col>
                    <v-col>{{stored.longitude.toFixed(2)}}</v-col>
                </v-row>
                <v-row>
                    <v-col>latitude:</v-col>
                    <v-col>{{stored.latitude.toFixed(2)}}</v-col>
                </v-row>
                <v-row>
                    <v-col>pressure:</v-col>
                    <v-col>{{stored.pressure.toFixed(2)}}</v-col>
                </v-row>
                <v-row>
                    <v-col>temperature:</v-col>
                    <v-col>{{stored.temperature.toFixed(2)}}</v-col>
                </v-row>
                <v-row>
                    <v-col>altitude:</v-col>
                    <v-col>{{stored.altitude.toFixed(2)}}</v-col>
                </v-row>
            </template>
        </v-card-text>
        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn icon @click="save">
                <v-icon dark>mdi-content-save-all</v-icon>
            </v-btn>
            <v-btn icon @click="load">
                <v-icon dark>mdi-file-upload-outline</v-icon>
            </v-btn>
            <v-btn icon @click="del">
                <v-icon dark>mdi-delete</v-icon>
            </v-btn>
        </v-card-actions>
    </v-card>
</template>

<script src="./SpiFlashWidget.js"></script>