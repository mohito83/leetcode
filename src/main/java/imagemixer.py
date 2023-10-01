import cv2
from cv2 import VideoWriter
from cv2 import VideoWriter_fourcc
import numpy as np
import random
import argparse
from moviepy.editor import ImageClip, AudioFileClip, VideoFileClip


def add_static_image_to_audio(image, audio, output):
    """Create and save a video file to `output_path` after
    combining a static image that is located in `image_path`
    with an audio file in `audio_path`"""
    # create the audio clip object
    audio_clip = AudioFileClip(audio)
    # create the image clip object
    image_clip = ImageClip(image)
    # use set_audio method from image clip to combine the audio with the image
    video_clip = image_clip.set_audio(audio_clip)
    # specify the duration of the new clip to be the duration of the audio clip
    video_clip.duration = audio_clip.duration
    # set the FPS to 1
    video_clip.fps = 1
    # write the resuling video clip
    video_clip.write_videofile(output)


def fade_in_vid(image_path, video_path):
    # open image file
    image = cv2.imread(image_path, cv2.IMREAD_UNCHANGED)

    # extract width and height from the original image
    width = image.shape[1]
    height = image.shape[0]

    # define video codec
    fourcc = VideoWriter_fourcc(*'MP4v')

    # define video stream
    video = VideoWriter(video_path, fourcc, float(24), (width, height))

    # init empty frame
    frame = np.zeros((height, width, 3), np.uint8)

    # frame count
    frame_count = 0

    # init random row indexes
    random_rows = list(range(len(image)))

    # shuffle rows' indexes in random order
    random.shuffle(random_rows)

    # loop over pixel rows in the original image
    for y in random_rows:
        # loop over pixels within a given row
        for x in range(len(image[y])):
            # draw pixel on frame
            cv2.circle(
                frame,  # frame to write pixel to
                (x, y),  # center coordinates of a circle
                1,  # circle radius
                (int(image[y][x][0]),  # pixel RED value
                 int(image[y][x][1]),  # pixel GREEN value
                 int(image[y][x][2])  # pixel BLUE value
                 ),
                -1  # thickness
            )

        # write video frame
        if y % 10 == 0:
            frame_count += 1
            video.write(frame)
            print('Writing frame:', frame_count)

    # keep image frame for some time...
    for i in range(100):
        # write complete frame
        video.write(frame)
        frame_count += 1
        print('Writing frame:', frame_count)
    # release video
    video.release()


def add_audio_to_video(output, audio):
    video_clip = VideoFileClip(output)
    audio_clip = AudioFileClip(audio)
    video_clip.set_audio(audio_clip)
    video_clip.write_videofile(output)


if __name__ == "__main__":
    parser = argparse.ArgumentParser(
        description="Simple Python script to add a static image to an audio to make a video")
    parser.add_argument("image", help="The image path")
    parser.add_argument("audio", help="The audio path")
    parser.add_argument("output", help="The output video file path")
    args = parser.parse_args()
    # create fading video
    # fade_in_vid(args.image, args.output)
    # add audio background to fading video
    # add_audio_to_video(args.output, args.audio)
    add_static_image_to_audio(args.image, args.audio, args.output)
