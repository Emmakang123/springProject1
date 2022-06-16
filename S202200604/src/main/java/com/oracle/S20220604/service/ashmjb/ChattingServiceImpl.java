package com.oracle.S20220604.service.ashmjb;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.oracle.S20220604.dao.ashmjb.ChattingDao;
import com.oracle.S20220604.domain.Chatting;
import com.oracle.S20220604.model.Message;
import com.oracle.S20220604.model.Participant;

@Service
@Transactional
public class ChattingServiceImpl implements ChattingService {
	private static final Logger logger = LoggerFactory.getLogger(ChattingServiceImpl.class);
	
	private final ChattingDao chattingDao;
	
	public ChattingServiceImpl(ChattingDao chattingDao) {
		this.chattingDao = chattingDao;
	}

	@Override
	public int insert(Chatting chatting) {
		logger.info("insert Start .. ");
		logger.info("insert chatting.getRoom_num-> " + chatting.getRoom_num());
		chattingDao.save(chatting);
		Participant pt = new Participant();
		pt.setUser_id(chatting.getUser_id());
		int saveParticipantResult = chattingDao.saveParticipant(pt);
		System.out.println("saveParticipantResult -> "+saveParticipantResult);
		return chatting.getRoom_num();
	}

	@Override
	public int total() {
		System.out.println("ChattingServiceImpl start total...");
		int totCnt = chattingDao.total();
		
		logger.info("total" + totCnt);
		return totCnt;
	
	}

	@Override
	public List<Chatting> openChatList(Chatting chatting) {
		List<Chatting> openChatList = null;
		System.out.println("ChattingServiceImpl openChatList start...");
		openChatList = chattingDao.openChatList(chatting);
//		System.out.println("ChattingServiceImpl openChatList.size() ->"+ openChatList.size());
		
		return openChatList;
	}

	@Override
	public List<Chatting> showList(Chatting chatting) {
		
		logger.info("showList start..., user_id ->" +chatting.getUser_id());
		List<Chatting> showList = chattingDao.showList(chatting);
		System.out.println(" return showList");
		return showList;
	}

	@Override
	public List<Message> msgnaeyong(int room_num) {
		System.out.println("ChattingServiceImpl room_num start :"+room_num);
		
		List<Message> msgnaeyong = chattingDao.msgnaeyong(room_num);
		
		System.out.println("ChattingServiceImpl room_num after :"+room_num);
		System.out.println("ChattingServiceImpl msgnaeyong size() :"+msgnaeyong.size());
		
		return msgnaeyong;
	}
	
	@Override
	public List<Chatting> keywordList(Chatting chatting) {
		List<Chatting> keywordList = null;
		System.out.println("ChattingServiceImpl keywordList Start...");
		if(chatting.getKeyword()!= null) {
			keywordList = chattingDao.keywordList(chatting);
			System.out.println("ChattingServiceImpl keywordList keywordList.size() -> "+ keywordList.size());
		}
		return keywordList;
	}
	@Override
	public void insertParti(Participant parti) {
		System.out.println("ChattingServiceImpl insertParti Start...");
		int result = chattingDao.insertParti(parti);
		System.out.println("ChattingServiceImpl  참여자등록 인서트문 결과 : "+ result);
		
	}
}
