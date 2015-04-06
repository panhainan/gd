package com.gd.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.coobird.thumbnailator.Thumbnails;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
@RequestMapping("/file")
public class UploadController implements ServletContextAware {

	/**
	 * @author phn
	 * @date 2015-3-31
	 * @TODO 上传图片
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param request
	 * @param poster
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/uploadPic.do", method = RequestMethod.POST)
	public String uploadPic(@RequestParam("x") int x,
			@RequestParam("y") int y, @RequestParam("width") int width,
			@RequestParam("height") int height,
			@RequestParam("realWidth") int realWidth,
			HttpServletRequest request,
			@RequestParam("poster") MultipartFile poster) {
//		System.out.println(realWidth);
		boolean uploadResultValue = false;
		if (realWidth > 500) {
			x = (int) (x * (realWidth / 500.0));
			y = (int) (y * (realWidth / 500.0));
			width = (int) (width * (realWidth / 500.0));
			height = (int) (height * (realWidth / 500.0));
		}
//		Map<String, Object> uploadResult = new HashMap<String, Object>();
		String uploadResult = "";
//		System.out.println(x + "   " + y + "   " + width + "  " + height);
		Calendar rightNow = Calendar.getInstance();
		String year = String.valueOf(rightNow.get(Calendar.YEAR));
		String month = String.valueOf(rightNow.get(Calendar.MONTH));
		try {
			String relativeImgSavePath = "/poster/" + year + "/"+ month ;
			String imgSavePath = request.getSession().getServletContext()
					.getRealPath("/images") + relativeImgSavePath;
			/** 根据真实路径创建目录* */
			File imgTrueSavePath = new File(imgSavePath);
			if (!imgTrueSavePath.exists())
				imgTrueSavePath.mkdirs();
			/** 获取文件的后缀* */
			String imgSuffix = poster.getOriginalFilename().substring(
					poster.getOriginalFilename().lastIndexOf("."));
			/** 使用UUID生成文件名称* */
			String imgSaveName = UUID.randomUUID().toString() + imgSuffix;// 构建文件名称
			String imgTrueNameSavePath = imgTrueSavePath +  "/" + imgSaveName;
			String relativeImgNameSavePath = relativeImgSavePath +  "/" + imgSaveName;
			poster.transferTo(new File(imgTrueNameSavePath));
			String registerURL = request.getRequestURL().toString();
			Thumbnails.of(imgTrueNameSavePath)
					.sourceRegion(x, y, width, height).size(width, height)
					.keepAspectRatio(false).toFile(imgTrueNameSavePath);
			String picSavedPath = registerURL.replace("file/uploadPic.do",
					"images") + relativeImgNameSavePath;
			System.out.println(picSavedPath);
			uploadResultValue = true;
			uploadResult="uploadResultValue:"+uploadResultValue+",picSavedPath:'"+ picSavedPath+"'";
		} catch (IllegalStateException e) {
			e.printStackTrace();
			uploadResult="uploadResultValue:"+uploadResultValue;
		} catch (IOException e) {
			e.printStackTrace();
			uploadResult="uploadResultValue:"+uploadResultValue;
		}
		return "<script>parent.callback({"+uploadResult+"})</script>";
	}

	@RequestMapping("/upload.do")
	public String addUser(@RequestParam("file") CommonsMultipartFile[] files,
			HttpServletRequest request) {
		for (int i = 0; i < files.length; i++) {
			System.out.println("fileName---------->"
					+ files[i].getOriginalFilename());
			if (!files[i].isEmpty()) {
				int pre = (int) System.currentTimeMillis();
				try {
					// 拿到输出流，同时重命名上传的文件
					FileOutputStream os = new FileOutputStream("E:/"
							+ new Date().getTime()
							+ files[i].getOriginalFilename());
					// 拿到上传文件的输入流
					FileInputStream in = (FileInputStream) files[i]
							.getInputStream();
					// 以写字节的方式写文件
					int b = 0;
					while ((b = in.read()) != -1) {
						os.write(b);
					}
					os.flush();
					os.close();
					in.close();
					int finaltime = (int) System.currentTimeMillis();
					System.out.println(finaltime - pre);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("上传出错");
				}
			}
		}
		return "/success";
	}

	@RequestMapping("/upload2.do")
	public String upload2(HttpServletRequest request,
			HttpServletResponse response) throws IllegalStateException,
			IOException {
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 记录上传过程起始时的时间，用来计算上传时间
				int pre = (int) System.currentTimeMillis();
				// 取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null) {
					// 取得当前上传文件的文件名称
					String myFileName = file.getOriginalFilename();
					// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if (myFileName.trim() != "") {
						System.out.println(myFileName);
						// 重命名上传后的文件名
						String fileName = "demoUpload"
								+ file.getOriginalFilename();
						// 定义上传路径
						String path = "E:/" + fileName;
						File localFile = new File(path);
						file.transferTo(localFile);
					}
				}
				// 记录上传该文件后的时间
				int finaltime = (int) System.currentTimeMillis();
				System.out.println(finaltime - pre);
			}

		}
		return "/success";
	}

	@RequestMapping("/toUpload.do")
	public String toUpload() {
		return "/upload.do";
	}

	@RequestMapping("/cutUpload.do")
	public String cutUpload(String name,
			@RequestParam("file") CommonsMultipartFile file) {
		if (!file.isEmpty()) {
			String path = this.servletContext.getRealPath("/tmp/"); // 获取本地存储路径
			System.out.println(path);
			String fileName = file.getOriginalFilename();
			String fileType = fileName.substring(fileName.lastIndexOf("."));
			System.out.println(fileType);
			File file2 = new File(path, new Date().getTime() + fileType); // 新建一个文件
			try {
				file.getFileItem().write(file2); // 将上传的文件写入新建的文件中
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:upload_ok.jsp";
		} else {
			return "redirect:upload_error.jsp";
		}
	}

	private ServletContext servletContext;

	@Override
	public void setServletContext(ServletContext servletContext) {
		// TODO Auto-generated method stub
		this.servletContext = servletContext;

	}
}
