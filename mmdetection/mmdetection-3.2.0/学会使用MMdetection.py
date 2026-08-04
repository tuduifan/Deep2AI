from mmdet.apis import DetInferencer
# 初始化推理器，传入模型名称 'rtmdet_tiny_8xb32-300e_coco'
inferencer = DetInferencer(
    model='configs/rtmdet/rtmdet_tiny_8xb32-300e_coco.py',
    weights='checkpoints/rtmdet_l/rtmdet_tiny_8xb32-300e_coco_20220902_112414-78e30dcc.pth'   # 使用您下载的实际文件名
)

# 对图片进行目标检测推理
# 参数1: 输入图片路径（也支持 numpy 数组、图片路径列表、文件夹路径）
# out_dir: 推理结果的输出目录，可视化图片保存在 output/vis/，预测结果保存在 output/preds/
result = inferencer('demo/demo.jpg', out_dir='output/')