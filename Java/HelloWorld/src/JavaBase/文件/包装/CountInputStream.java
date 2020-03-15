package JavaBase.文件.包装;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CountInputStream extends FilterInputStream {
    private int count = 0;

    CountInputStream(InputStream in) {
        super(in);
    }

    public int getBytesRead() {
        return this.count;
    }

    @Override
    public int read() throws IOException {
        int n = super.read();
        if (n != -1) {
            this.count++;
        }
        return n;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int n = super.read(b, off, len);
        if (n != -1) {
            this.count += n;
        }
        return n;
    }

    @Override
    public int read(byte[] b) throws IOException {
        int n = super.read(b);
        if (n != -1) {
            this.count += n;
        }
        return n;
    }
}
