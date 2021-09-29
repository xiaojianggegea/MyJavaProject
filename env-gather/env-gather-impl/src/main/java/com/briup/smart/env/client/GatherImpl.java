package com.briup.smart.env.client;

import com.briup.smart.env.entity.Environment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;

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
        FileReader fr = null;
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader(path));
            String line = "";
            Environment env = null;
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
                        break;
                    case "256":

                        break;
                    case "1280":

                        break;
                    default:
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fr != null) {
                fr.close();
            }
            if (bf != null) {
                bf.close();
            }
        }
        return null;
    }

    private int getData(String data,int index) {
        if(index==1){
            data = data.substring(0,4);
        }else if(index==2){
            data = data.substring(4,8);
        }else{
            throw new RuntimeException("index只能是1或2");
        }
        return Integer.parseInt(data,16);
    }
}
