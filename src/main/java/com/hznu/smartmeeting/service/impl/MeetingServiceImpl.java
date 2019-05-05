package com.hznu.smartmeeting.service.impl;

import com.hznu.smartmeeting.entity.Meeting;
import com.hznu.smartmeeting.dao.MeetingDao;
import com.hznu.smartmeeting.service.MeetingService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 会议表 服务实现类
 * </p>
 *
 * @author AppleWld
 * @since 2019-03-20
 */
@Service
public class MeetingServiceImpl extends ServiceImpl<MeetingDao, Meeting> implements MeetingService {

}
