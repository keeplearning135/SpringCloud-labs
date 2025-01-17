package com.keeplearning135.zookeeper.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
public class ZkApi {
    @Autowired
    private ZooKeeper zkClient;

    public Stat exists(String path, boolean needWatch){
        try {
            return zkClient.exists(path,needWatch);
        } catch (Exception e) {
            log.error("【断指定节点是否存在异常】{},{}",path,e);
            return null;
        }
    }

    public Stat exists(String path, Watcher watcher){
        try {
            return zkClient.exists(path,watcher);
        } catch (Exception e) {
            log.error("【断指定节点是否存在异常】{},{}",path,e);
            return null;
        }
    }

    public boolean createNode(String path, String data){
        try {
            zkClient.create(path,data.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            return true;
        } catch (Exception e) {
            log.error("【创建持久化节点异常】{},{},{}",path,data,e);
            return false;
        }
    }

    public boolean updateNode(String path, String data){
        try {
            //zk的数据版本是从0开始计数的。如果客户端传入的是-1，则表示zk服务器需要基于最新的数据进行更新。如果对zk的数据节点的更新操作没有原子性要求则可以使用-1.
            //version参数指定要更新的数据的版本, 如果version和真实的版本不同, 更新操作将失败. 指定version为-1则忽略版本检查
            zkClient.setData(path,data.getBytes(),-1);
            return true;
        } catch (Exception e) {
            log.error("【修改持久化节点异常】{},{},{}",path,data,e);
            return false;
        }
    }

    public boolean deleteNode(String path){
        try {
            //version参数指定要更新的数据的版本, 如果version和真实的版本不同, 更新操作将失败. 指定version为-1则忽略版本检查
            zkClient.delete(path,-1);
            return true;
        } catch (Exception e) {
            log.error("【删除持久化节点异常】{},{}",path,e);
            return false;
        }
    }

    public List<String> getChildren(String path) throws KeeperException, InterruptedException{
        List<String> list = zkClient.getChildren(path, false);
        return list;
    }

    public  String getData(String path,Watcher watcher){
        try {
            Stat stat=new Stat();
            byte[] bytes=zkClient.getData(path,watcher,stat);
            return new String(bytes);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }
}
