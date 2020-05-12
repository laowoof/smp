package com.oceansoft.szga.smp.szsh.core.entity.system;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CmChunk  implements Serializable {
    private static final long serialVersionUID = 6419371205206579599L;

    @TableId
    private String id;

    /**
     * 当前文件块，从1开始
     */
    private Integer chunkNumber;
    /**
     * 分块大小
     */
    private Integer chunkSize;
    /**
     * 当前分块大小
     */
    private Integer currentChunkSize;
    /**
     * 总大小
     */
    private Integer totalSize;
    /**
     * 文件标识
     */
    private String identifier;
    /**
     * 文件名
     */
    private String fileName;
    /**
     * 相对路径
     */
    private String relativePath;
    /**
     * 总块数
     */
    private Integer totalChunks;
    /**
     * 文件类型
     */
    private String type;

    @TableField(exist = false)
    private MultipartFile file;
}
