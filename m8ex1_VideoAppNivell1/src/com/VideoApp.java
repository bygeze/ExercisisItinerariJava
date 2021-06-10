package com;

import application.VideoAppController;

public class VideoApp {
	public VideoApp() {}
	
	public void init() {
		VideoAppController controller = new VideoAppController();
		controller.init();
	}
}
