package kz.yamuz.services;

import kz.yamuz.domain.Track;

import kz.yamuz.repositories.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {
    @Autowired
    TrackRepository trackRepository;

    @Override
    public Iterable<Track> listAllHabits() {
        return trackRepository.findAll();
    }

    @Override
    public Track getTrackById(Long id) {
        Optional<Track> optional =trackRepository.findById(id);
        if (optional.isEmpty())
            throw  new RuntimeException("No such habit track with id : " + id);

        return optional.get();
    }

    @Transactional
    @Override
    public Track saveTrack(Track track) {
        return trackRepository.save(track);
    }

    @Override
    public void deleteTrack(Long id) {

        trackRepository.deleteById(id);
    }
}
