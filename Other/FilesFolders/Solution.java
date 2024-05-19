import java.util.concurrent.*;

class FilesFolders {
    List<String> files;
    List<String> folders;

    FilesFolders(List<String> files, List<String> folders) {
        this.files = files;
        this.folders = folders;
    }
}

interface Callback {
    void callback(List<String> files, List<String> folders);
}

class Drive {
    void get_async(String path, Callback callback) {
        // Simulating asynchronous operation
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            // Simulate network latency
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Mocked files and folders
            List<String> files = List.of("file1.txt", "file2.txt");
            List<String> folders = List.of("folder1", "folder2");

            // Call callback function
            callback.callback(files, folders);
        });
        executor.shutdown();
    }
}

public class Main {
    static Drive drive = new Drive();

    public static void main(String[] args) {
        Search("path", "substring", new Callback() {
            @Override
            public void callback(List<String> files, List<String> folders) {
                // Handle callback
                System.out.println("Files: " + files);
                System.out.println("Folders: " + folders);
            }
        });
    }

    static void Search(String path, String subString, Callback callback) {
        drive.get_async(path, new Callback() {
            @Override
            public void callback(List<String> files, List<String> folders) {
                // Search through files
                for (String file : files) {
                    if (file.contains(subString)) {
                        callback.callback(Collections.singletonList(file), Collections.emptyList());
                        return;
                    }
                }

                // Search through folders
                for (String folder : folders) {
                    if (folder.contains(subString)) {
                        callback.callback(Collections.emptyList(), Collections.singletonList(folder));
                        return;
                    }
                }

                // If not found
                callback.callback(Collections.emptyList(), Collections.emptyList());
            }
        });
    }
}
