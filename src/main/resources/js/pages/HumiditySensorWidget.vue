<template>
    <v-card class="mx-auto my-12" max-width="250" :loading="loading" height="100%">
        <v-img height="200" src="/flash.png"></v-img>
        <v-card-title>Temperature and Pressure</v-card-title>
        <v-card-text>
            <v-row align="center" class="mx-0">
                <v-col cols="4">Pressure:</v-col>
                <v-col>{{value}}</v-col>
            </v-row>
            <v-row align="center" class="mx-0">
                <v-col cols="4">Temp C:</v-col>
                <v-col>{{value}}</v-col>
            </v-row>
            <v-row align="center" class="mx-0">
                <v-col cols="4">Altitude:</v-col>
                <v-col>{{value}}</v-col>
            </v-row>
        </v-card-text>
    </v-card>
</template>

<script src="./HumiditySensorWidget.js"></script>
