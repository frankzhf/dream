## for centos
1) tar -xjf ffmpeg-3.2.3.tar.bz2
2) move unzip folder to /usr/src
3) git clone git://git.videolan.org/x264.git or tar -xf x264.tar
4) within x264 folder run ./configure --enable-shared --enable-static
5) run make && make install
6) within ffmpeg folder run ./configure --enable-gpl --enable-libx264
7) run make && make install
8) ln -s /usr/local/bin/ffmpeg /usr/bin/ffmpeg
