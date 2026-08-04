FROM continuumio/miniconda3

WORKDIR /app

# 1. 安装编译工具和 OpenCV 依赖（修正后的包名）
RUN apt-get update && apt-get install -y \
    build-essential \
    cmake \
    libgl1 \
    libglib2.0-0 \
    libsm6 \
    libxext6 \
    libxrender-dev \
    && rm -rf /var/lib/apt/lists/*

# 2. 创建 Conda 环境并安装 PyTorch（CUDA 11.3）
RUN conda create -n openmmlab python=3.8 -y && \
    conda run -n openmmlab conda install pytorch torchvision torchaudio cudatoolkit=11.3 -c pytorch -y

# 3. 复制源码到镜像
COPY . /app/mmdetection

# 4. 安装 MMDetection（-e 开发模式）
RUN conda run -n openmmlab pip install -e /app/mmdetection

# 显式安装 mmcv 和 mmengine（避免依赖解析失败）
RUN conda run -n openmmlab pip install mmcv==2.1.0 mmengine==0.10.7

# 5. 激活环境
ENV PATH="/opt/conda/envs/openmmlab/bin:$PATH"

CMD ["/bin/bash"]