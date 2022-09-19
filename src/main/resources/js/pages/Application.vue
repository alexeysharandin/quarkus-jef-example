<template>
    <div>
        <v-card class="mx-auto" max-width="100%">
            <v-container fluid>
                <v-row dense>
                    <v-col>
                        <ambient-light></ambient-light>
                    </v-col>
                    <v-col>
                        <gpio-led></gpio-led>
                    </v-col>
                    <v-col>
                        <gps></gps>
                    </v-col>
                    <v-col>
                        <humidity-sensor></humidity-sensor>
                    </v-col>
                    <v-col>
                        <spi-flash></spi-flash>
                    </v-col>
                </v-row>
            </v-container>
        </v-card>
    </div>
</template>

<script src="./Application.js"></script>