package com.briup.smart.env.client;

import com.briup.smart.env.entity.Environment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @program: env-gather
 * @description: 采集模块的实现类
 * @author: 小江
 * @create: 2021-09-27 20:12
 **/

public class GatherImpl implements Gather {
    @Override
    public Collection<Environment> gather() throws Exception {
        String path = "F:\\杰普上课资料\\day7-物联网\\env-gather\\env-gather-impl\\src\\main\\resources\\data-file-simple";
        BufferedReader bf = null;
        List<Environment> list  = new ArrayList<>();
        try {
            bf = new BufferedReader(new FileReader(path));
            String line = "";
            Environment env = null;
            Environment envCopy = null;
            while ((line = bf.readLine()) != null) {
                String[] fields = line.split("[|]");
                //数据格式不匹配则跳出循环
                if (fields.length != 9) {
                    // TODO 记录当前数据格式有问题的数据
                    continue;
                }
                // 获取sicId
                env.setSrcId(fields[0]);
                // 树莓派系统ID
                env.setDesId(fields[1]);
                // 实验箱区域模块ID
                env.setDevId(fields[2]);
                // 模块上传感器地址
                // 16，表示温度和湿度数据。256，表示光照强度数据 。1280，表示二氧化碳数据
                env.setSersorAddress(fields[3]);
                // 传感器个数
                env.setCount(Integer.valueOf(fields[4]));
                // 发送指令标号 3表示接收数据 16表示发送命令
                env.setCmd(fields[5]);
                //环境值
                String data = fields[6];
                // 状态 默认1表示成功
                env.setStatus(Integer.valueOf(fields[7]));
                // 采集时间
                env.setGather_date(new Timestamp(Long.valueOf(fields[8])));
                //处理传感器地址以及环境值
                switch (fields[3]) {
                    case "16":
                        env.setName("温度");
                        float temperatureData = (this.getData(data)*(0.00268127F))- 46.85F;
                        env.setData(temperatureData);
                        envCopy = this.copy(env);
                        envCopy.setName("湿度");
                        float humidityData = (this.getData(data,2)*0.00190735F)-6;
                        envCopy.setData(humidityData);
                        list.add(env);
                        list.add(envCopy);
                        break;
                    case "256":
                        env.setName("光照强度");
                        env.setData(getData(data));
                        list.add(env);
                        break;
                    case "1280":
                        env.setName("二氧化碳");
                        env.setData(getData(data));
                        list.add(env);
                        break;
                    default:
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bf != null) {
                bf.close();
            }
        }
        return list;
    }

    private Environment copy(Environment env) {
        Environment copy = new Environment();
        copy.setSrcId(env.getSrcId());
        // 树莓派系统ID
        copy.setDesId(env.getDesId());
        // 实验箱区域模块ID
        copy.setDevId(env.getDevId());
        // 模块上传感器地址
        copy.setSersorAddress(env.getSersorAddress());
        // 传感器个数
        copy.setCount(env.getCount());
        // 发送指令标号 3表示接收数据 16表示发送命令
        copy.setCmd(env.getCmd());
        //环境值
        copy.setData(env.getData());
        // 状态 默认1表示成功
        copy.setStatus(env.getStatus());
        // 采集时间
        copy.setGather_date(env.getGather_date());
        return copy;
    }

    private int getData(String data,int i) {
        if(i==1){
            data = data.substring(0,4);
        }else if(i==2){
            data = data.substring(4,8);
        }else{
            throw new RuntimeException("index只能是1或2");
        }
        return Integer.parseInt(data,16);
    }
    private int getData(String data) {
        data = data.substring(0,4);
        return Integer.parseInt(data,16);
    }
}
