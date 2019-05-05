package com.hznu.smartmeeting.service;

import com.hznu.smartmeeting.entity.Meeting;
import com.hznu.smartmeeting.entity.Personal;
import com.baomidou.mybatisplus.service.IService;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 * 人员表 服务类
 * </p>
 *
 * @author AppleWld
 * @since 2019-03-20
 */
public interface PersonalService extends IService<Personal> {
    Personal loginByAccount(String accountNumber, String password);
    Meeting getCurrentMeeting(int id);
    List<Meeting> getMeetingList(int id);
}
