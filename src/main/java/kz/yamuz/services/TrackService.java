package kz.yamuz.services;


import kz.yamuz.domain.Track;

public interface TrackService {
    Iterable<Track> listAllHabits();

    Track getTrackById(Long id);

    Track saveTrack(Track track);

    void deleteTrack(Long id);
}
