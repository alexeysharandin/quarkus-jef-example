<template>
    <v-card class="mx-auto my-12" max-width="230" height="100%">
        <v-img height="200" src="/led.png"></v-img>
        <v-card-title>GPIO</v-card-title>
        <v-card-text>
            <v-row>
                <v-col>Enable or disable LED</v-col>
            </v-row>
            <v-row>
                <v-col>status {{status}}</v-col>
            </v-row>
        </v-card-text>
        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn icon @click="on">
                <v-icon dark>mdi-car-light-dimmed</v-icon>
            </v-btn>
            <v-btn icon @click="off">
                <v-icon dark>mdi-car-light-fog</v-icon>
            </v-btn>
        </v-card-actions>
    </v-card>
</template>

<script src="./GpioLedWidget.js"></script>