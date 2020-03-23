//
//
//package com.partTime.decode;
//
//import android.graphics.Bitmap;
//import android.graphics.Rect;
//import android.hardware.Camera.Size;
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Looper;
//import android.os.Message;
//
//import com.example.maibenben.part_time1.Activity.SaoActivity;
//import com.example.maibenben.part_time1.R;
//import com.google.zxing.BinaryBitmap;
//import com.google.zxing.DecodeHintType;
//import com.google.zxing.MultiFormatReader;
//import com.google.zxing.PlanarYUVLuminanceSource;
//import com.google.zxing.ReaderException;
//import com.google.zxing.Result;
//import com.google.zxing.common.HybridBinarizer;
//
//import java.io.ByteArrayOutputStream;
//import java.util.Map;
//
//
//public class DecodeHandler extends Handler {
//
//	private final SaoActivity activity;
//	private final MultiFormatReader multiFormatReader;
//	private boolean running = true;
//
//	public DecodeHandler(SaoActivity saoActivty, Map<DecodeHintType, Object> hints) {
//		multiFormatReader = new MultiFormatReader();
//		multiFormatReader.setHints(hints);
//		this.activity=saoActivty;
//	}
//
//	@Override
//	public void handleMessage(Message message) {
//		if (!running) {
//			return;
//		}
//		switch (message.what) {
//		case R.id.decode:
//			decode((byte[]) message.obj, message.arg1, message.arg2);
//			break;
//		case R.id.quit:
//			running = false;
//			Looper.myLooper().quit();
//			break;
//		}
//	}
//
//	private void decode(byte[] data, int width, int height) {
//		Size size = activity.getCameraManager().getPreviewSize();
//
//		// 这里需要将获取的data翻转一下，因为相机默认拿的的横屏的数据
//		byte[] rotatedData = new byte[data.length];
//		for (int y = 0; y < size.height; y++) {
//			for (int x = 0; x < size.width; x++)
//				rotatedData[x * size.height + size.height - y - 1] = data[x + y * size.width];
//		}
//
//		// 宽高也要调整
//		int tmp = size.width;
//		size.width = size.height;
//		size.height = tmp;
//
//		Result rawResult = null;
//		PlanarYUVLuminanceSource source = buildLuminanceSource(rotatedData, size.width, size.height);
//		if (source != null) {
//			BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
//			try {
//				rawResult = multiFormatReader.decodeWithState(bitmap);
//			} catch (ReaderException re) {
//				// continue
//			} finally {
//				multiFormatReader.reset();
//			}
//		}}
//
//
//
//	private static void bundleThumbnail(PlanarYUVLuminanceSource source, Bundle bundle) {
//		int[] pixels = source.renderThumbnail();
//		int width = source.getThumbnailWidth();
//		int height = source.getThumbnailHeight();
//		Bitmap bitmap = Bitmap.createBitmap(pixels, 0, width, width, height, Bitmap.Config.ARGB_8888);
//		ByteArrayOutputStream out = new ByteArrayOutputStream();
//		bitmap.compress(Bitmap.CompressFormat.JPEG, 50, out);
//		bundle.putByteArray(DecodeThread.BARCODE_BITMAP, out.toByteArray());
//	}
//
//	public PlanarYUVLuminanceSource buildLuminanceSource(byte[] data, int width, int height) {
//		Rect rect = activity.getCropRect();
//		if (rect == null) {
//			return null;
//		}
//		// Go ahead and assume it's YUV rather than die.
//		return new PlanarYUVLuminanceSource(data, width, height, rect.left, rect.top, rect.width(), rect.height(), false);
//	}
//
//}
