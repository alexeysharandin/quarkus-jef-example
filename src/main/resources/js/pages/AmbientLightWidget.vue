<template>
    <v-card class="mx-auto my-12" max-width="230" height="100%">
        <v-img height="200" src="/lux.png"></v-img>
        <v-card-title>Ambient Light</v-card-title>
        <v-card-text>
            <v-row align="center" class="mx-0">
                <v-col cols="4">Light:</v-col>
                <v-col>{{lux}} lux</v-col>
            </v-row>
        </v-card-text>
    </v-card>
</template>

<script src="./AmbientLightWidget.js"></script>
