package kr.spring.musinfo.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.spring.musinfo.vo.CommentsVO;

public class CommentsValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return CommentsVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"rev_rate","required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"review","required");
	}

}






