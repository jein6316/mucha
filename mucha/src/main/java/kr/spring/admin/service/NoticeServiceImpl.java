package kr.spring.admin.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.spring.admin.dao.NoticeMapper;
import kr.spring.admin.vo.NoticeVO;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{
	
	@Resource
	NoticeMapper noticeMapper;
		
	@Override
	public List<NoticeVO> selectList(Map<String, Object> map) {
		return noticeMapper.selectList(map);
	}

	@Override
	public int selectRowCount(Map<String, Object> map) {
		return noticeMapper.selectRowCount(map);
	}

	@Override
	public void insertNotice(NoticeVO notice) {
		noticeMapper.insertNotice(notice);
	}

	@Override
	public NoticeVO selectNotice(Integer no_num) {
		return noticeMapper.selectNotice(no_num);
	}

	@Override
	public void updateNoticeHit(Integer no_num) {
		noticeMapper.updateNoticeHit(no_num);
	}

	@Override
	public void updateNotice(NoticeVO notice) {
		noticeMapper.updateNotice(notice);
	}

	@Override
	public void deleteNotice(Integer no_num) {
		noticeMapper.deleteNotice(no_num);
	}

	@Override
	public int selectMemberNoitceRowCount(Map<String, Object> map) {
		return noticeMapper.selectMemberNoitceRowCount(map);
	}

	@Override
	public List<NoticeVO> selectMemberNoticeList(Map<String, Object> map) {
		return noticeMapper.selectMemberNoticeList(map);
	}
	
}
