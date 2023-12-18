package spring.review.demo.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import spring.review.demo.sys.entity.Community;
import spring.review.demo.sys.mapper.CommunityMapper;
import spring.review.demo.sys.service.ICommunityService;

import java.util.List;

/**
 * 社区内容服务实现类
 */
@Service
public class CommunityServiceImpl extends ServiceImpl<CommunityMapper, Community> implements ICommunityService {

    @Autowired
    private CommunityMapper communityMapper;

    /**
     * 获取所有社区内容
     */
    public List<Community> getAllCommunities() {
        return communityMapper.selectList(null);
    }

    /**
     * 根据公司ID获取社区内容
     * @param companyId 公司ID
     */
    public List<Community> getCommunitiesByCompanyId(Integer companyId) {
        QueryWrapper<Community> wrapper = new QueryWrapper<>();
        wrapper.eq("companies_id", companyId);
        return communityMapper.selectList(wrapper);
    }
}
