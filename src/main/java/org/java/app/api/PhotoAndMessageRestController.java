package org.java.app.api;

import java.util.List;

import org.java.app.api.dto.MessageDTO;
import org.java.app.db.Message;
import org.java.app.db.Photo;
import org.java.app.db.service.MessageService;
import org.java.app.db.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/v1.0")
public class PhotoAndMessageRestController {

	@Autowired
	private PhotoService photoService;
	@Autowired
	private MessageService messageService;

	// __________API_PHOTO______________________________
	@GetMapping("/all")
	public ResponseEntity<List<Photo>> getAllPhotos() {
		System.out.println("inviate foto api");
		return new ResponseEntity<List<Photo>>(photoService.findByAll(), HttpStatus.OK);
	}

	@PostMapping("/{title}")
	public ResponseEntity<List<Photo>> getPhotosByTitle(@PathVariable String title) {

		return new ResponseEntity<List<Photo>>(photoService.findByTitle(title), HttpStatus.OK);
	}

	// __________API_MESSAGE______________________________
	@PostMapping("/store")
	public ResponseEntity<Integer> save(@RequestBody MessageDTO messageDTO) {
		System.out.println("gen new mess");
		Message message = new Message(messageDTO);

		System.out.println("Api Message SAVE:\n" + message);
		message = messageService.save(message);

		return new ResponseEntity<>(message.getId(), HttpStatus.OK);
	}
	
}
