package obsoletereference.weakhashmap;

import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHashMapTest {
    public static void main(String[] args) throws InterruptedException {

        HashMap<UniqueImageName, BigImage> strongMap = new HashMap<>();
        WeakHashMap<UniqueImageName, BigImage> weakMap = new WeakHashMap<>();

        BigImage bigImageFirst_strong = new BigImage("image1_strong_reference");
        UniqueImageName imageNameFirst_strong = new UniqueImageName("name_of_big_image_1");

        BigImage bigImageSecond_strong = new BigImage("image2_strong_reference");
        UniqueImageName imageNameSecond_strong = new UniqueImageName("name_of_big_image_2");

        BigImage bigImageFirst_weak = new BigImage("image1_weak_reference");
        UniqueImageName imageNameFirst_weak = new UniqueImageName("name_of_big_image_1");

        BigImage bigImageSecond_weak = new BigImage("image2_weak_reference");
        UniqueImageName imageNameSecond_weak = new UniqueImageName("name_of_big_image_2");


        strongMap.put(imageNameFirst_strong, bigImageFirst_strong);
        strongMap.put(imageNameSecond_strong, bigImageSecond_strong);
        weakMap.put(imageNameFirst_weak, bigImageFirst_weak);
        weakMap.put(imageNameSecond_weak, bigImageSecond_weak);

        System.out.println("-------- HashMaps size before memory cleaning -----------\n");
        System.out.println("HashMap size = " + strongMap.size());
        System.out.println("WeakHashMap size = " + strongMap.size());

        imageNameFirst_strong = null;
        imageNameFirst_weak = null;

        System.out.println("\nRunning GC...\n");
        System.gc();
        System.out.println("-------- HashMaps size after memory cleaning -----------\n");

        do {
            Thread.sleep(2000);
            System.out.println("HashMap size = " + strongMap.size());
            System.out.println("WeakHashMap size = " + weakMap.size() + "\n");
        }
        while (weakMap.containsValue(bigImageFirst_weak));
    }

    static class BigImage {
        String imageId;

        BigImage(String imageId) {
            this.imageId = imageId;
        }
    }

    static class UniqueImageName {
        String imageName;

        UniqueImageName(String imageName) {
            this.imageName = imageName;
        }
    }
}



