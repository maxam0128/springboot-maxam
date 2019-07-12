package com.maxam.kafka;

import lombok.Data;

import java.util.Date;

/**
 * @author fanjinlong
 * @date 2019-07-11 20:27
 **/
@Data
public class MessageDTO {

	private Long id;

	private Object data;

	private Date createTime;
}
