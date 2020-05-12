package com.oceansoft.szga.smp.szsh.core.mapper.system;

import com.oceansoft.szga.smp.szsh.core.entity.system.CmChunk;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ChunkMapper extends BaseMapper<CmChunk> {
}
