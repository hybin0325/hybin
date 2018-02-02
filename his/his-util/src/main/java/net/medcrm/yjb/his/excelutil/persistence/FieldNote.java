package net.medcrm.yjb.his.excelutil.persistence;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.FIELD,
		java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.PARAMETER,
		java.lang.annotation.ElementType.TYPE, java.lang.annotation.ElementType.LOCAL_VARIABLE,
		java.lang.annotation.ElementType.CONSTRUCTOR, java.lang.annotation.ElementType.PACKAGE })
public @interface FieldNote {
	String logicalName() default "";

	String physicalName() default "";

	boolean notNull() default false;
}
