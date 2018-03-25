package com.baomidou.springboot.test.zk;

import lombok.extern.slf4j.Slf4j;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

@Slf4j
public class ZKClientDemo {
    private static final String zkServers = "127.0.0.1";
    private static final int connectionTimeout = 3000;
    private static final String path = "/zk-data-demo";

    public static void main(String[] args) throws Exception {
        ZkClient zkClient = new ZkClient(zkServers, connectionTimeout);
        // 若节点已经存在，则删除
        if (zkClient.exists(path)) {
            zkClient.delete(path);
        }
        // 创建持久节点
        zkClient.createPersistent(path);
        // 节点写入数据
        zkClient.writeData(path, "zkclient_test_data_1");

        // 节点读取数据
        String data = zkClient.readData(path, true);
        log.info("====zkClient.readData====>{}", data);

        // 注册监听器，监听数据变化
        zkClient.subscribeDataChanges(path, new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                log.info("====>dataPath:{}, data:{}", s, o);
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                log.info("====>dataPath:{}", s);
            }
        });

        // 修改数据
        zkClient.writeData(path, "zkclient_test_data_1_update");
        // 删除节点
        zkClient.delete(path);

        // 5 minutes
        Thread.sleep(5 * 60000L);
    }
}
