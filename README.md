# Week 6 Daily 1

1. Create an application to use the Flickr api.

    You can use the following endpoint to get the images http://api.flickr.com/services/feeds/photos_public.gne?tag=kitten&format=json&nojsoncallback=1

2. Screen 1: Should show a recycler view with all the images from the api. Each ItemView should have a thumbnail of the image and two more fields.

3. On Clicking long press on each item a dialog box with two options will appear. “Show full image” and “Show small image”. You can add options to the array in an xml and pass to the dialog. https://developer.android.com/guide/topics/ui/dialogs.html#AddingAList

4. “Show full image” will start a new activity and cover the whole screen with the passed picture.

5. “Show small image” will show the image in a dialog in the same activity

6. YOU MUST USE DAGGER2 AND MVP

-----------------------------------

This is how the app looks:

| Main Activity | On Long Click | Small Image | Full Image |
| ----------------- | ----------------- | ----------------- | ----------------- |
| ![alt text][img1] | ![alt text][img2] | ![alt text][img3] | ![alt text][img4] | 

[img1]: https://github.com/a00512098/screenshots/blob/master/week6day1/device-2019-03-19-090318.png?raw=true "Main Activity"
[img2]: https://github.com/a00512098/screenshots/blob/master/week6day1/device-2019-03-19-090402.png?raw=true "On Long Click"
[img3]: https://github.com/a00512098/screenshots/blob/master/week6day1/device-2019-03-19-090430.png?raw=true "Small Image"
[img4]: https://github.com/a00512098/screenshots/blob/master/week6day1/device-2019-03-19-090520.png?raw=true "Full Image"
