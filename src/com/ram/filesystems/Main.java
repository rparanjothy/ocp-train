package com.ram.filesystems;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.time.Instant;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("I am FileSystem Examples");

//        Path repr files and folders
        Path a = Paths.get("busObj");
        System.out.println(a.toAbsolutePath());
        ///Users/bujji/Projects/ocp_lessons/busObj
        Path a1 = Paths.get("hello.txt");
//        Just path attrs.. cant create a new file with path instance

        File f = new File("hello.txt");
        System.out.println(f.exists());
//        creates a new file
        f.createNewFile();

//        FileSystems => describes available F/S
        FileSystem fs = FileSystems.getDefault();
        System.out.println(fs);
//        sun.nio.fs.MacOSXFileSystem@75bd9247

          fs.getFileStores().forEach(System.out::println);
          /*
          / (/dev/disk1s1)
            /dev (devfs)
            /private/var/vm (/dev/disk1s4)
            /net (map -hosts)
            /home (map auto_home)
           */

        fs.getRootDirectories().forEach(System.out::println);

        System.out.println(fs.getUserPrincipalLookupService().lookupPrincipalByGroupName("staff").toString()
        );

//        PATH TO FILE use the toFile() and toPath()
        Path a2 = Paths.get("hello1.adele");
        File f2 = a2.toFile();
        f2.createNewFile();

//        use static method writeString
        Files.writeString(a2,"Hello Adele!!"+ Instant.now());


        Path p3 = Path.of("/","Users","bujji","bujji","ocp1");
        System.out.println(p3);
        Path p4 = p3.getFileName();
        System.out.println(p3.getNameCount());
//        shows how many levels

        System.out.println( p3.resolve("../a"));
//        /Users/bujji/bujji/ocp1/../a
        System.out.println( p3.resolve("../a").normalize());
//        /Users/bujji/bujji/a


//        Creating Dirs

        Path dp = Path.of(".","b","c","d");
        System.out.println(dp.normalize());
        Files.createDirectories(dp);


    }
}
