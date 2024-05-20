package mod.coder2195.america.entity.client;

import mod.coder2195.america.AmericaMod;
import mod.coder2195.america.entity.custom.BulletEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;

public class BulletEntityRenderer extends ProjectileEntityRenderer<BulletEntity> {
   public static final Identifier TEXTURE = new Identifier(AmericaMod.MOD_ID, "textures/entity/projectiles/bullet.png");

   public BulletEntityRenderer(EntityRendererFactory.Context context) {
      super(context);
   }

   public Identifier getTexture(BulletEntity arrowEntity) {
      return TEXTURE;
   }

   @Override
   public void render(BulletEntity persistentProjectileEntity, float f, float g, MatrixStack matrixStack,
         VertexConsumerProvider vertexConsumerProvider, int i) {
      Vec3d velocity = persistentProjectileEntity.getVelocity();

      super.render(persistentProjectileEntity, f, g, matrixStack, vertexConsumerProvider, i);
   }
}
