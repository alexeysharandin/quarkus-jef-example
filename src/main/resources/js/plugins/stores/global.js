import Vue from 'vue'
import http from '../http'

const log = Vue.$log;

const state = {
    lux: 0,
    gpio: false,
    longitude: 0,
    latitude: 0,
    pressure: 0,
    temperature: 0,
    altitude: 0,
    stored: '',
}

const getters = {
}

const mutations = {
    loadLuxMutation(state, data) {
        //log.debug("mutate lux property: " + data);
        state.lux = data;
    },
    loadGpioMutation(state, data) {
        log.debug("mutate gpio property: " + data);
        state.gpio = data;
    },
    loadGpsMutation(state, data) {
        //log.debug("mutate gps property: " + data);
        state.longitude = data.longitude;
        state.latitude = data.latitude;
    },
    loadBcm280Mutation(state, data) {
        //log.debug("mutate bcm280 property: " + data);
        state.pressure = data.pressure;
        state.temperature = data.temperature;
        state.altitude = data.altitude;
    },
    loadStoredMutation(state, data) {
        log.debug("mutate stored property: " + data);
        state.stored = data;
    },
}

const actions = {
    async loadLux({commit}) {
        const response = await http.light();
        if (response) {
            const data = await response.data;
            commit("loadLuxMutation", data);
        }
    },
    async updateGpio({commit}, status) {
        const response = await http.gpio(status);
        if (response) {
            const data = await response.data;
            commit("loadGpioMutation", data);
        }
    },
    async loadGps({commit}) {
        const response = await http.gps();
        if (response) {
            const data = await response.data;
            commit("loadGpsMutation", data);
        }
    },
    async loadBcm280({commit}) {
        const response = await http.bmp280();
        if (response) {
            const data = await response.data;
            commit("loadBcm280Mutation", data);
        }
    },
    async storeData({commit, state}) {
        const response = await http.store(state);
        if (response) {
            const data = await response.data;
            return true;
        }
        return false;
    },
    async loadData({commit}) {
        const response = await http.load();
        if (response) {
            const data = await response.data;
            commit("loadStoredMutation", data);
        }
    },
    async deleteData({commit}) {
        const response = await http.delete();
        if (response) {
            const data = await response.data;
            commit("loadStoredMutation", data);
        }
    },
}

export default {
    namespaced: true,
    state,
    getters,
    actions,
    mutations
}