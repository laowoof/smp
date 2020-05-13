package com.oceansoft.szga.smp.szsh.common.util;

import com.oceansoft.szga.smp.szsh.core.entity.system.CmChunk;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author wx
 * @date 2018/10/20
 * 文件相关工具
 */
@Slf4j
public class FileUtils {

    public static String generatePath(String uploadFolder, CmChunk chunk) {
        StringBuilder sb = new StringBuilder();
        sb.append(uploadFolder).append("/").append(chunk.getIdentifier());
        //判断uploadFolder/identifier 路径是否存在，不存在则创建
        if (!Files.isWritable(Paths.get(sb.toString()))) {
//            log.info("path not exist,create path: {}", sb.toString());
            try {
                Files.createDirectories(Paths.get(sb.toString()));
            } catch (IOException e) {
                log.error(e.getMessage(), e);
            }
        }

        return sb.append("/")
                .append(chunk.getFileName())
                .append("-")
                .append(chunk.getChunkNumber()).toString();
    }

    /**
     * 文件合并
     *
     * @param targetFile
     * @param folder
     */
    public static void merge(String targetFile, String folder, String filename) {
        try {
            Files.createFile(Paths.get(targetFile));
            Files.list(Paths.get(folder))
                    .filter(path -> !path.getFileName().toString().equals(filename))
                    .sorted((o1, o2) -> {
                        String p1 = o1.getFileName().toString();
                        String p2 = o2.getFileName().toString();
                        int i1 = p1.lastIndexOf("-");
                        int i2 = p2.lastIndexOf("-");
                        return Integer.valueOf(p2.substring(i2)).compareTo(Integer.valueOf(p1.substring(i1)));
                    })
                    .forEach(path -> {
                        try {
                            //以追加的形式写入文件
                            Files.write(Paths.get(targetFile), Files.readAllBytes(path), StandardOpenOption.APPEND);
                            //合并后删除该块
                            Files.delete(path);
                        } catch (IOException e) {
                            log.error(e.getMessage(), e);
                        }
                    });
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }



    /**
     * 根据文件类型转换 接口用
     *
     * @param fileType
     * @retrun 0图片、1视频、2其他
     */
    public static String getFileType(String fileType){
        String type="2";
        if(StringUtils.isEmpty(fileType)){
            return type;
        }
        if(fileType.indexOf("image")>=0){
            type="0";
        }
        else if(fileType.indexOf("video")>=0||fileType.indexOf("audio")>=0){
            type="1";
        }
        return type;
    }






}
