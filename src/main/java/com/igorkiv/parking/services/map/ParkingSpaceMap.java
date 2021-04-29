package com.igorkiv.parking.services.map;

import com.igorkiv.parking.model.ParkingSpace;
import com.igorkiv.parking.services.ParkingSpaceService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service("ParkingSpaceMap")
@Profile({"default", "map"})
public class ParkingSpaceMap extends AbstractMapService<ParkingSpace, Long> implements ParkingSpaceService {

    @Override
    public Set<ParkingSpace> findAll() {

//        Set<ParkingSpace> hashSetToTreeSet = new TreeSet<ParkingSpace>();
//        for (ParkingSpace i : super.findAll())
//            hashSetToTreeSet.add(i);
//        return hashSetToTreeSet;

//        TreeSet<ParkingSpace> myTreeSet = new TreeSet<>();
//        Set<ParkingSpace> mySet = new HashSet<>();
//        mySet.addAll(super.findAll());
//        myTreeSet.addAll(mySet);
//        return myTreeSet;
        return super.findAll();
//        return list.stream().collect(Collectors.toCollection(TreeSet::new super.findAll());
    }

    @Override
    public ParkingSpace findById(Long id) {
        return super.findById(id);
    }

    @Override
    public ParkingSpace save(ParkingSpace object) {
        return super.save(object);
    }

    @Override
    public void delete(ParkingSpace object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteByIf(id);

    }

}
