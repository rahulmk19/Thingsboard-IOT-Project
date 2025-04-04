package com.iot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iot.service.ThingsBoardIOTService;

@RequestMapping("/iot")
@RestController
public class ThingsBoardIOTController {

	private final ThingsBoardIOTService thingsBoardIOTService;

	public ThingsBoardIOTController(ThingsBoardIOTService thingsBoardIOTService) {
		this.thingsBoardIOTService = thingsBoardIOTService;
	}

}
