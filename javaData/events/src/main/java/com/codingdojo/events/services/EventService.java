package com.codingdojo.events.services;

import java.util.List;
import java.util.Optional;

import com.codingdojo.events.models.Event;
import com.codingdojo.events.models.Comment;
import com.codingdojo.events.repositories.CommentRepository;
import com.codingdojo.events.repositories.EventRepository;

import org.springframework.stereotype.Service;

@Service
public class EventService {
    private final EventRepository eventRepository;
    private final CommentRepository commentRepository;

    public EventService(EventRepository eventRepository, CommentRepository commentRepository) {
        this.eventRepository = eventRepository;
        this.commentRepository = commentRepository;
    }

    // returns all the events
    public List<Event> findAllEvents() {
        return (List<Event>) eventRepository.findAll();
    }

    // retrieve an event
    public Event findEventById(Long id) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isPresent()) {
            return optionalEvent.get();
        } else {
            return null;
        }
    }

    // create an event
    public Event createEvent(Event event) {
        return this.eventRepository.save(event);
    }

    // update an event
    public Event updateEvent(Event event) {
        return eventRepository.save(event);
    }

    // deletes an event
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    // returns all the comments
    public List<Comment> findAlLComments() {
        return (List<Comment>) commentRepository.findAll();
    }

    // retrieve a comment
    public Comment findCommentById(Long id) {
        Optional<Comment> optionalComment = commentRepository.findById(id);
        if (optionalComment.isPresent()) {
            return optionalComment.get();
        } else {
            return null;
        }
    }

    // create a comment
    public Comment createComment(Comment comment) {
        return this.commentRepository.save(comment);
    }

    // update a comment
    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    // deletes a comment
    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
