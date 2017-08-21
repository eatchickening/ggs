package io.checken.ggs.common.util;


import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

/**
 * Hibernate-Validator 校验工具类
 *
 * @author wungmc 2017/7/26.
 */
public class ValidatorUtils {
    private static Validator validator;
    private static Validator validatorLazy; // Fail-Fast 校验模式

    static {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        validatorLazy = Validation.byProvider( HibernateValidator.class )
                .configure()
                .failFast( true )
                .buildValidatorFactory()
                .getValidator();
    }

    /**
     * 校验对象
     * @param object        待校验对象
     * @param groups        待校验的组
     * @return 返回所有错误信息，参数全部合法，则返回null
     */
    public static String validateEntity(Object object, Class<?>... groups) {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            StringBuilder msg = new StringBuilder();
            for(ConstraintViolation<Object> constraint:  constraintViolations){
                msg.append(constraint.getMessage()).append("，");
            }
            return msg.toString();
        }
        return null;
    }

    /**
     * Fail-Fast的校验对象，只要发现有失败存在，则立即返回
     * @param object
     * @param groups
     * @return
     */
    public static ValidateErrorResult validateEntityLazy(Object object, Class<?>... groups) {
        Set<ConstraintViolation<Object>> constraintViolations = validatorLazy.validate(object, groups);
        if (!constraintViolations.isEmpty()) {
            for(ConstraintViolation<Object> constraint:  constraintViolations){
                return new ValidateErrorResult(constraint.getPropertyPath().toString(), constraint.getMessage());
            }
        }
        return null;
    }
}
