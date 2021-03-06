package net.baba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.baba.domain.Boy;
import net.baba.enums.ResultEnum;
import net.baba.exception.BoyException;
import net.baba.repository.BoyRepository;

/**
 * boyService实现类
 * 
 * @author 乔凯华 2017年4月27日 下午5:09:45
 * @version 1.0
 */
@Service
public class BoyServiceImpl implements BoyService {

	@Autowired
	private BoyRepository boyRepository;
	
	@Override
	@Transactional
	public Boy save(Boy boy) {
		return boyRepository.save(boy);
	}

//	@Override
//	public List<Boy> findBoyListByAge(Integer age) throws Exception{
//		if(age < 18){
//			throw new BoyException(500,"年龄不满18岁");
//		}else if(age > 150){
//			throw new BoyException(505,"你属乌龟的,活这么久!");
//		}
//		return boyRepository.findByAge(age);
//	}
	
	/**
	 * 统一异常返回结果
	 * @param age
	 * @return
	 * @throws Exception
	 * @see net.baba.service.BoyService#findBoyListByAge(java.lang.Integer)
	 * @author 乔凯华 2017年4月28日 下午1:05:18
	 * @version 1.0
	 */
	@Override
	public List<Boy> findBoyListByAge(Integer age) throws Exception{
		if(age < 18){
			throw new BoyException(ResultEnum.TOO_YOUNG);
		}else if(age > 150){
			throw new BoyException(ResultEnum.TOO_OLD);
		}
		return boyRepository.findByAge(age);
	}
	


}
