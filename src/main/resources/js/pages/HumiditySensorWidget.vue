<template>
    <v-card class="mx-auto my-12" max-width="230" height="100%">
        <v-img height="200" src="/temp.png"></v-img>
        <v-card-title>Temp C and Pressure</v-card-title>
        <v-card-text>
            <v-row align="center" class="mx-0">
                <v-col cols="5">Pressure:</v-col>
                <v-col>{{pressure.toFixed(2)}}</v-col>
            </v-row>
            <v-row align="center" class="mx-0">
                <v-col cols="5">Temp C:</v-col>
                <v-col>{{temperature.toFixed(2)}}</v-col>
            </v-row>
            <v-row align="center" class="mx-0">
                <v-col cols="5">Altitude:</v-col>
                <v-col>{{altitude.toFixed(2)}}</v-col>
            </v-row>
        </v-card-text>
    </v-card>
</template>

<script src="./HumiditySensorWidget.js"></script>
