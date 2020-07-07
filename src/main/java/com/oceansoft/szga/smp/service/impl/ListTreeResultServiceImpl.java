package com.oceansoft.szga.smp.service.impl;

import com.oceansoft.szga.smp.entity.TreeDeptResult;
import com.oceansoft.szga.smp.mapper.TreeResultMapper;
import com.oceansoft.szga.smp.service.ListTreeResultService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 树形查询实现层
 *
 * @author JackChan
 * @Date 2020/7/1 0001 下午 3:56
 */
@Service
public class ListTreeResultServiceImpl implements ListTreeResultService {

    @Autowired
    private TreeResultMapper treeResultMapper;

    @Override
    public TreeDeptResult getDeptTreeResult() {
        // 获取根节点
//        TreeDeptResult root = treeResultMapper.getRoot();
        List<TreeDeptResult> all = treeResultMapper.all();
        Map<String, List<TreeDeptResult>> treeNodeMap = new HashMap<>();
//        all.forEach(result -> {
//            List<TreeDeptResult> child2 = treeNodeMap.computeIfAbsent(result.getParentId(), s -> new LinkedList<>());
//            child2.add(result);
//        });
        TreeDeptResult root = null;
        for (TreeDeptResult deptResult : all) {
            if (deptResult.getParentId() == null) {
                root = deptResult;
            } else {
                List<TreeDeptResult> child = treeNodeMap.get(deptResult.getParentId());
                if (CollectionUtils.isNotEmpty(child)) {
                    child.add(deptResult);
                } else {
                    child = new LinkedList<>();
                    child.add(deptResult);
                    treeNodeMap.put(deptResult.getParentId(), child);
                }
//            List<TreeDeptResult> child2 = treeNodeMap.computeIfAbsent(deptResult.getParentId(), s -> new LinkedList<>());
//            child2.add(deptResult);
            }
        }
        treeNode(root, root.getId(), treeNodeMap);
        return root;
    }

    /**
     * 获取树形下派部门
     *
     * @param id
     * @return
     */
    @Override
    public List<TreeDeptResult> getLowerDeptTreeResult(String id) {
        if (StringUtils.isEmpty(id)) {
            throw new RuntimeException("id 不能为空");
        }
        List<TreeDeptResult> all = treeResultMapper.all();
        Map<String, List<TreeDeptResult>> treeNodeMap = new HashMap<>();

        for (TreeDeptResult deptResult : all) {
            List<TreeDeptResult> child = treeNodeMap.get(deptResult.getParentId());
            if (CollectionUtils.isNotEmpty(child)) {
                child.add(deptResult);
            } else {
                child = new LinkedList<>();
                child.add(deptResult);
                treeNodeMap.put(deptResult.getParentId(), child);
            }
        }
        List<TreeDeptResult> children = treeNodeMap.get(id);
        if (CollectionUtils.isEmpty(children)) {
            return Collections.EMPTY_LIST;
        } else {
            treeLowerNode(children, treeNodeMap);
            return children;
        }
    }


    private void treeLowerNode(List<TreeDeptResult> children, Map<String, List<TreeDeptResult>> treeNodeMap) {
        if (CollectionUtils.isNotEmpty(children)) {
            for (TreeDeptResult deptResult : children) {
                List<TreeDeptResult> nodeList = treeNodeMap.get(deptResult.getId());
                deptResult.setChildren(nodeList);
                if (CollectionUtils.isNotEmpty(nodeList)) {
                    treeLowerNode(nodeList, treeNodeMap);
                }
            }
        }
    }

    /**
     * 根据 当前节点的id，获取下级子节点
     *
     * @param parentNode  当前
     * @param parentId    节点id
     * @param treeNodeMap 节点DP
     */
    public void treeNode(TreeDeptResult parentNode, String parentId, Map<String, List<TreeDeptResult>> treeNodeMap) {
        List<TreeDeptResult> childTreeResult = treeNodeMap.get(parentId);
        if (CollectionUtils.isNotEmpty(childTreeResult)) {
            parentNode.setChildren(childTreeResult);
            for (TreeDeptResult node : childTreeResult) {
                treeNode(node, node.getId(), treeNodeMap);
            }
        }
    }


    public List<String> toStringList(String str) {
        List<String> list = Arrays.asList(str.split(",")).stream().map(s -> (s.trim())).collect(Collectors.toList());
        return list;

    }

}
