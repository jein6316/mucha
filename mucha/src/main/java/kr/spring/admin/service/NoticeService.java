package kr.spring.admin.service;

import java.util.List;
import java.util.Map;

import kr.spring.admin.vo.NoticeVO;



public interface NoticeService {
	public List<NoticeVO> selectList(Map<String,Object> map);
	public int selectRowCount(Map<String, Object> map);
	public void insertNotice(NoticeVO notice);
	public NoticeVO selectNotice(Integer no_num);
	public void updateNoticeHit(Integer no_num);
	public void updateNotice(NoticeVO notice);
	public void deleteNotice(Integer no_num);
	public int selectMemberNoitceRowCount(Map<String, Object> map);
	public List<NoticeVO> selectMemberNoticeList(Map<String, Object> map);
}
