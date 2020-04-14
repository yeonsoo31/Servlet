package com.icia.board.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.*;

@Data
public class BoardDTO {
	private int bnumber;
	private String bwriter;
	private String bpassword;
	private String btitle;
	private String bcontents;
	private Date bdate;
	private int bhits;
	private MultipartFile bfile;
	private String bfilename;
}
