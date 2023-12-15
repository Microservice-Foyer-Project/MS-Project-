const Eureka = require('eureka-js-client').Eureka;

const eurekaConfig = {
  instance: {
    app: 'departementMS', 
    hostName: 'localhost', 
    ipAddr: '127.0.0.1',
    port: {
      '$': 3000, 
      '@enabled': 'true',
    },
    vipAddress: 'departementMS',
    dataCenterInfo: {
      '@class': 'com.netflix.appinfo.InstanceInfo$DefaultDataCenterInfo',
      name: 'MyOwn',
    },
  },
  eureka: {
    serviceUrls: {
      default: ['http://localhost:8761/eureka/apps/'],
    },
  },
};

const eurekaClient = new Eureka(eurekaConfig);
module.exports = eurekaClient;