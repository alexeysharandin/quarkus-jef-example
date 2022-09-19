const common  = require('./webpack.common.js');
const path = require('path');
const { merge } = require('webpack-merge');

module.exports = merge(common, {
    mode: 'development',
    devtool: 'source-map',
    output: {
        publicPath: '/',
        filename: '[name].js',
    },
    devServer: {
            static: './dist',
            compress: true,
            port: 7001,
            hot: true,
            host: '0.0.0.0',
            allowedHosts: [
                'all'
            ],
            client: {
                  overlay: {
                    errors: true,
                    warnings: false,
                  },
                  logging: 'info',
                  webSocketTransport: 'ws',
            },
            webSocketServer: 'ws',
        },
});